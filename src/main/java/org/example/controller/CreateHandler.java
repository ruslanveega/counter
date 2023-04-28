package org.example.controller;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.example.repository.CountersRepository;

import java.io.IOException;
import java.io.OutputStream;

public class CreateHandler implements HttpHandler {
    CountersRepository countersRepository;
    public CreateHandler(CountersRepository countersRepository) {
        this.countersRepository = countersRepository;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String query = exchange.getRequestURI().getQuery();
        String name = query.split("=")[1];
        countersRepository.addCounter(Integer.valueOf(name));
        String response = String.format("Counter with id=%s was created", name);
        exchange.sendResponseHeaders(200, response.getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
