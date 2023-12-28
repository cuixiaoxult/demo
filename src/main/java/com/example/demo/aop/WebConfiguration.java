//package com.example.demo.aop;
//
//import com.opay.iam.core.config.IamAppLogInterceptor;
//import com.opay.iam.core.config.IamInterceptor;
//import com.opay.iam.core.config.IamLoginInterceptor;
//import com.opay.sso.filter.AuthWebFilter;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import javax.servlet.Filter;
//
//@Configuration
//public class WebConfiguration implements WebMvcConfigurer {
//
//    /**
//     * sso的地址
//     */
//    @Value("${opay.sso.url:https://sso-new.opayweb.com/}")
//    private String ssoUrl;
//    /**
//     * 登录成功后返回应用的地址
//     */
//    @Value("${opay.sso.demo.url:https:localhost:11001}")
//    private String ssoDemoUrl;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        // 1.首次登录拦截
//        // "/controller/api/login/success" : 拦截指定的API，登录成功后的首页，会从会话中获取用户信息，初始化IAM系统中的用户
//        registry.addInterceptor(new IamLoginInterceptor())
//                .addPathPatterns("/controller/api/login/success");
//        // 2.鉴权拦截
//        // 拦截所有，自定义忽略不需要鉴权的API，例如登录相关和错误相关的（如下）
//        registry.addInterceptor(new IamInterceptor())
//                .addPathPatterns("/**")
//                .excludePathPatterns("/error/**")
//                .excludePathPatterns("/login/**");
//        // 3.应用操作审计拦截器（配置后会每隔10分钟将应用操作上传到IAM系统）
//        registry.addInterceptor(new IamAppLogInterceptor())
//                .addPathPatterns("/**")
//                .excludePathPatterns("/error/**")
//                .excludePathPatterns("/test/**")
//                .excludePathPatterns("/dashboard/**")
//                .excludePathPatterns("/login/**");
//    }
//
//    /**
//     * 配置过滤器
//     *
//     * @return
//     */
//    @Bean
//    public FilterRegistrationBean someFilterRegistration() {
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setFilter(authWebFilter());
//        registration.addUrlPatterns("/*");
//        registration.addInitParameter("paramName", "paramValue");
//        registration.setName("authWebFilter");
//        return registration;
//    }
//
//    /**
//     * 创建一个bean
//     *
//     * @return
//     */
//    public Filter authWebFilter() {
//        return new AuthWebFilter(ssoUrl, ssoDemoUrl);
//    }
//}
