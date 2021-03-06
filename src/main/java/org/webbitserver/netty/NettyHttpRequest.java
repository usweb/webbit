package org.webbitserver.netty;

import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.handler.codec.http.HttpRequest;

import java.net.SocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class NettyHttpRequest implements org.webbitserver.HttpRequest {

    private final HttpRequest httpRequest;
    private final MessageEvent messageEvent;
    private final Map<String, Object> data = new HashMap<String, Object>();
    private final Object id;
    private final long timestamp;

    public NettyHttpRequest(MessageEvent messageEvent, HttpRequest httpRequest, Object id, long timestamp) {
        this.messageEvent = messageEvent;
        this.httpRequest = httpRequest;
        this.id = id;
        this.timestamp = timestamp;
    }

    @Override
    public String uri() {
        return httpRequest.getUri();
    }

    @Override
    public String header(String name) {
        return httpRequest.getHeader(name);
    }

    @Override
    public boolean hasHeader(String name) {
        return httpRequest.containsHeader(name);
    }

    @Override
    public String method() {
        return httpRequest.getMethod().getName();
    }

    @Override
    public Map<String, Object> data() {
        return data;
    }

    @Override
    public Object data(String key) {
        return data.get(key);
    }

    @Override
    public NettyHttpRequest data(String key, Object value) {
        data.put(key, value);
        return this;
    }

    @Override
    public Set<String> dataKeys() {
        return data.keySet();
    }

    @Override
    public SocketAddress remoteAddress() {
        return messageEvent.getRemoteAddress();
    }

    @Override
    public Object id() {
        return id;
    }

    @Override
    public long timestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return messageEvent.getRemoteAddress() + " " + httpRequest.getMethod() + " " + httpRequest.getUri();
    }
}
