package org.example.controller;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class HelloHandler implements HttpHandler {

    private static final int CODE = 200;
    
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String message = "Hello, world!";
        int messageLen = message.getBytes(StandardCharsets.UTF_8).length;
        exchange.sendResponseHeaders(CODE, messageLen);
        OutputStream response = exchange.getResponseBody();
        response.write(message.getBytes(StandardCharsets.UTF_8));
        response.close();
    }
}
