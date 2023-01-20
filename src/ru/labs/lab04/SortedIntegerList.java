package ru.labs.lab04;

import java.util.Iterator;
import java.util.LinkedList;

public class SortedIntegerList {
    private final LinkedList<Integer> list;
    boolean repeats = false;

    public SortedIntegerList() {
        list = new LinkedList<>();
    }

    public SortedIntegerList(boolean repeats) {
        list = new LinkedList<>();
        this.repeats = repeats;
    }

    public SortedIntegerList(SortedIntegerList list) {
        this.list = new LinkedList<>(list.list);
        this.repeats = list.repeats;
    }

    public void add(int value) {
        if (repeats) {
            list.add(value);
            return;
        }
        for (Integer integer : list) {
            if (integer == value) {
                return;
            }
        }
        list.add(value);
    }

    public void remove(int value) {
        for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext();) {
            Integer integer = iterator.next();
            if (integer == value) {
                iterator.remove();
                return;
            }
        }
    }

    public int size() {
        return list.size();
    }

    public boolean equals(SortedIntegerList list) {
        if (this.size() != list.size()) {
            return false;
        }
        for (int i = 0; i < this.size(); i++) {
            if (this.list.get(i) != list.list.get(i)) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        return list.toString();
    }
}
