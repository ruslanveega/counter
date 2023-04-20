package org.example.repository;

import org.example.model.Counter;

import java.util.ArrayList;
import java.util.List;

public class CountersRepository {

    public static List<Counter> Counters = new ArrayList<>();

    public CountersRepository() {
    }

    public static void addCounter(int id) {
        Counters.add(new Counter(id));
    }
    public static List<Counter> getAllCounters() {
        return Counters;
    }
    public static Counter getCounterByld(int id) {
        for (Counter counter : Counters) {
            if (counter.getId() == id)
                return counter;
        }
        return null;
    }

    public static void incrementCounterByld(int id) {
        for (Counter counter : Counters) {
            if (counter.getId() == id) {
                counter.setId(id + 1);
                break;
            }
        }
    }

    public static void removeCounterByld(int id) {
        for (Counter counter : Counters) {
            if (counter.getId() == id) {
                Counters.remove(counter);
                break;
            }
        }
    }
}
