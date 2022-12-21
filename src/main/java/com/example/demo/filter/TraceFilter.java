package com.example.demo.filter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author cuixiaoxu
 */
@Slf4j
@WebFilter(
        filterName = "TraceFilter",
        urlPatterns = {"/*"}
)
@Component
public class TraceFilter implements Filter {

    public TraceFilter() {
    }

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filter) throws IOException, ServletException {
        MDC.put("traceId", UUID.randomUUID().toString().replace("-", ""));
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        log.info("uri:{},method:{}", httpServletRequest.getRequestURI(), httpServletRequest.getMethod());
        StringBuilder msg = new StringBuilder();
        msg.append("uri=").append(httpServletRequest.getRequestURI());
        String queryString = httpServletRequest.getQueryString();
        if (queryString != null) {
            msg.append('?').append(queryString);
        }

        String client = request.getRemoteAddr();
        if (StringUtils.hasLength(client)) {
            msg.append(";client=").append(client);
        }

        long startTime = System.currentTimeMillis();
        msg.append(";headers=").append(this.dealwithHeaders((new ServletServerHttpRequest(httpServletRequest)).getHeaders()));

        try {
            LogHolder.setMessage("message", msg.toString());
            if (request.getContentType() == null || !request.getContentType().toLowerCase().contains("application/json") && !request.getContentType().toLowerCase().contains("application/boom-phone")) {
                log.info("LogHolder:{}", LogHolder.getMessage("message"));
                filter.doFilter(request, response);
            } else {
                LoggingHttpServletRequestWrapper requestWrapper = new LoggingHttpServletRequestWrapper((HttpServletRequest) request);
                BufferedReader bufferedReader = requestWrapper.getReader();
                msg.append(";payload=");
                StringBuilder payload = new StringBuilder();

                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    payload.append(line);
                }

                LogHolder.setMessage("payload", payload.toString());
                msg.append(payload);
                msg.append(";method=" + httpServletRequest.getMethod());
                LogHolder.setMessage("message", msg.toString());
                log.info("LogHolder:{}", LogHolder.getMessage("message"));
                filter.doFilter(requestWrapper, response);
            }
        } finally {
            log.info("uri：" + httpServletRequest.getRequestURI() + ";method=" + httpServletRequest.getMethod() + " . client: " + client + " .  cost time :" + (System.currentTimeMillis() - startTime) + " ms");
            MDC.remove("traceId");
            LogHolder.remove();
        }

    }

    private String dealwithHeaders(HttpHeaders headers) {
        return headers.entrySet().stream().filter((stringListEntry) -> {
            if ("token".equals(stringListEntry.getKey())) {
                return true;
            } else if ("mobile".equals(stringListEntry.getKey())) {
                return true;
            } else if ("version".equals(stringListEntry.getKey())) {
                return true;
            } else if ("platform".equals(stringListEntry.getKey())) {
                return true;
            } else if ("language".equals(stringListEntry.getKey())) {
                return true;
            } else if ("nonce".equals(stringListEntry.getKey())) {
                return true;
            } else if ("sign".equals(stringListEntry.getKey())) {
                return true;
            } else if ("timestamp".equals(stringListEntry.getKey())) {
                return true;
            } else {
                return "app".equals(stringListEntry.getKey());
            }
        }).map((stringListEntry) -> stringListEntry.getKey() + ":" + ((List) stringListEntry.getValue()).stream().collect(Collectors.joining(" "))).collect(Collectors.joining(";"));
    }
}
