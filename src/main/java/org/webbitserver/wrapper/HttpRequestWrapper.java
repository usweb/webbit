package org.webbitserver.wrapper;

import org.webbitserver.HttpRequest;

import java.net.SocketAddress;
import java.util.Map;
import java.util.Set;

public class HttpRequestWrapper implements HttpRequest {

    private HttpRequest request;

    public HttpRequestWrapper(HttpRequest request) {
        this.request = request;
    }

    public HttpRequest underlyingRequest() {
        return request;
    }

    public HttpRequestWrapper underlyingRequest(HttpRequest request) {
        this.request = request;
        return this;
    }

    public HttpRequest originalRequest() {
        if (request instanceof HttpRequestWrapper) {
            HttpRequestWrapper wrapper = (HttpRequestWrapper) request;
            return wrapper.originalRequest();
        } else {
            return request;
        }
    }

    @Override
    public String uri() {
        return request.uri();
    }

    @Override
    public String header(String name) {
        return request.header(name);
    }

    @Override
    public boolean hasHeader(String name) {
        return request.hasHeader(name);
    }

    @Override
    public String method() {
        return request.method();
    }

    @Override
    public Map<String, Object> data() {
        return request.data();
    }

    @Override
    public Object data(String key) {
        return request.data(key);
    }

    @Override
    public HttpRequestWrapper data(String key, Object value) {
        request.data(key, value);
        return this;
    }

    @Override
    public Set<String> dataKeys() {
        return request.dataKeys();
    }

    @Override
    public SocketAddress remoteAddress() {
        return request.remoteAddress();
    }

    @Override
    public Object id() {
        return request.id();
    }

    @Override
    public long timestamp() {
        return request.timestamp();
    }
}
