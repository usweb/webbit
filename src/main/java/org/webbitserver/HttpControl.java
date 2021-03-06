package org.webbitserver;

import java.util.concurrent.Executor;

public interface HttpControl extends Executor {

    void nextHandler();

    void nextHandler(HttpRequest request, HttpResponse response);

    void nextHandler(HttpRequest request, HttpResponse response, HttpControl control);

    WebSocketConnection upgradeToWebSocketConnection(WebSocketHandler handler);

    WebSocketConnection createWebSocketConnection();

    Executor handlerExecutor();
}
