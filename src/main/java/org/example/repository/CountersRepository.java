package org.example.repository;

import org.example.model.Counter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class CountersRepository {

    public Map<Integer, Counter> counters = new HashMap<>();

    public void addCounter(int id) {
        counters.put(id, new Counter(id));
    }
    public Collection<Counter> getAllCounters() {
        return counters.values();
    }
    public Counter getCounterByld(int id) {
            return counters.get(id);
    }

    public void incrementCounterByld(int id) {
        counters.get(id).increment();
    }

    public void removeCounterByld(int id) {
        counters.remove(id);
    }
}
