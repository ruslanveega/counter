package org.example.controller;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.example.model.Counter;
import org.example.repository.CountersRepository;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class CountersHandler implements HttpHandler {

    private static final int SUCCESS_CODE = 200;
    private final CountersRepository countersRepository;

    public CountersHandler(CountersRepository countersRepository) {
       this.countersRepository = countersRepository;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        countersRepository.addCounter(1);
        countersRepository.addCounter(2);
        countersRepository.incrementCounterByld(1);
        String message = countersRepository.getAllCounters().toString();
        int messageLen = message.getBytes(StandardCharsets.UTF_8).length;
        exchange.sendResponseHeaders(SUCCESS_CODE, messageLen);
        OutputStream response = exchange.getResponseBody();
        response.write(message.getBytes(StandardCharsets.UTF_8));
        response.close();
    }
}
