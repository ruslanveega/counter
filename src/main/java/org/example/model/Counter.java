package org.example.model;

public class Counter {
    private int value;
    private int id;

    public Counter(int id) {
        this.value = value;
        this.id = id;
    }

    public void increment() {
        this.value++;
    }
    public int getValue() {
        return value;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "{" +
                "\"value\":" + value +
                "\"id\":" + id +
                '}';
    }
}
