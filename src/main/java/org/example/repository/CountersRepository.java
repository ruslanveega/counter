package org.example.repository;

import org.example.model.Counter;

import java.util.*;

public class CountersRepository {

    public static Map<Integer, Counter> counters = new HashMap<>();

    public static void addCounter(int id) {
        counters.put(id, new Counter(id));
    }
    public static Collection<Counter> getAllCounters() {
        return counters.values();
    }
    public static Counter getCounterByld(int id) {
            return counters.get(id);
    }

    public static void incrementCounterByld(int id) {
        counters.get(id).increment();
    }

    public static void removeCounterByld(int id) {
        counters.remove(id);
    }
}
