package com.java.basics;

import java.util.*;

public class FunctionExample {

    public static void main(String[] args){
        method(new ArrayList<Number>());
    }

    public static void method(List<? extends Number> list) {
        Number n = list.get(0);
    }

    public static void method2() {
        Map<String, List<String>> map = new HashMap<>();
        map.put("str", new ArrayList<String>());
    }
}
