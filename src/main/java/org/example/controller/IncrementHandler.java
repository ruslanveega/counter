package org.example.controller;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.example.repository.CountersRepository;

import java.io.IOException;
import java.io.OutputStream;

public class IncrementHandler implements HttpHandler {

    private final CountersRepository countersRepository;
    public IncrementHandler(CountersRepository countersRepository) {
        this.countersRepository = countersRepository;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String query = exchange.getRequestURI().getQuery();
        String name = query.split("=")[1];
        countersRepository.incrementCounterByld(Integer.valueOf(name));
        String response = String.format("Counter %s was incremented", name);
        exchange.sendResponseHeaders(200, response.getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
