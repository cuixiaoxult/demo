package com.example.demo.filter;
import org.apache.tomcat.util.http.fileupload.IOUtils;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.*;

/**
 * @author cuixiaoxu
 */
public class LoggingHttpServletRequestWrapper extends HttpServletRequestWrapper {

    private ByteArrayOutputStream cachedBytes;

    public LoggingHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    public ServletInputStream getInputStream() throws IOException {
        if (this.cachedBytes == null) {
            this.cacheInputStream();
        }

        return new CachedServletInputStream();
    }

    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(this.getInputStream()));
    }

    private void cacheInputStream() throws IOException {
        this.cachedBytes = new ByteArrayOutputStream();
        IOUtils.copy(super.getInputStream(), this.cachedBytes);
    }

    public void updateInputStream(InputStream inputStream) throws IOException {
        if (this.cachedBytes != null) {
            this.cachedBytes.close();
        }

        this.cachedBytes = new ByteArrayOutputStream();
        IOUtils.copy(inputStream, this.cachedBytes);
    }

    public class CachedServletInputStream extends ServletInputStream {
        private ByteArrayInputStream input;

        public CachedServletInputStream() {
            this.input = new ByteArrayInputStream(LoggingHttpServletRequestWrapper.this.cachedBytes.toByteArray());
        }

        public boolean isFinished() {
            return false;
        }

        public boolean isReady() {
            return false;
        }

        public void setReadListener(ReadListener readListener) {
        }

        public int read() throws IOException {
            return this.input.read();
        }
    }
}
