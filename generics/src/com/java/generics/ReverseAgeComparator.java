package com.java.generics;

import java.util.Comparator;

public class ReverseAgeComparator<T> implements Comparator<T> {

    private Comparator<T> comparator;

    public ReverseAgeComparator(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    @Override
    public int compare(T left, T right) {
        return comparator.compare(right, left);
    }
}
