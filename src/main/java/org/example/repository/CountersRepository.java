package org.example.repository;

import org.example.model.Counter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountersRepository {

    public static Map<Integer, Counter> Counters = new HashMap<>();

    public static void addCounter(int id) {
        Counters.put(id, new Counter(id));
    }
    public static Map<Integer, Counter> getAllCounters() {
        return Counters;
    }
    public static Counter getCounterByld(int id) {
            return Counters.get(id);
    }

    public static void incrementCounterByld(int id) {
        Counters.get(id).increment();
    }

    public static void removeCounterByld(int id) {
        Counters.remove(id);
    }
}
