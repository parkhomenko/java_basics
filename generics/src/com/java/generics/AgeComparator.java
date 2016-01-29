package com.java.generics;

import java.util.Comparator;

public class AgeComparator implements Comparator<Dog> {
    @Override
    public int compare(Dog left, Dog right) {
        return Integer.compare(left.age, right.age);
    }
}
