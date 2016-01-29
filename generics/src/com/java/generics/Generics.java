package com.java.generics;

import java.util.*;

public class Generics {

    public static void main(String[] args) {

        /*
        List lst = new ArrayList();
        lst.add(5);

        String result = (String) lst.get(0);
        System.out.println(result);
        */

        Wrapper<String> wrapper = new Wrapper<String>("something");

        Node<Integer, String> node = new Node<>(5, "value");

        /* Wrong assignment
        List<Object> someList = new ArrayList<String>();
        someList.add(new Object());
        String str = (String)someList.get(0);
        */

        /*
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Turtle");
        arrayList.add("Monkey");
        arrayList.add("Cat");

        Collections.sort(arrayList);

        System.out.println(arrayList);
        */

        Dog dog1 = new Dog(7, "Fluffy");
        Dog dog2 = new Dog(2, "Jinny");
        Dog dog3 = new Dog(3, "Sammy");

        List<Dog> dogs = new ArrayList<>();
        dogs.add(dog1);
        dogs.add(dog2);
        dogs.add(dog3);

        Collections.sort(dogs, new AgeComparator());

        System.out.println(dogs);

        Collections.sort(dogs, new ReverseAgeComparator<>(new AgeComparator()));

        Dog dog = max(dogs, new AgeComparator());

        System.out.println(dog);
    }

    /* Method without generics
    public static Object max(List values, Comparator comparator) {
        Object max = values.get(0);
        for (int i = 0; i < values.size(); i++) {
            if (comparator.compare(max, values.get(i)) > 0) {
                max = values.get(i);
            }
        }
        return max;
    }
    */

    //Generic method
    public static <T> T max(List<T> values, Comparator<T> comparator) {
        T max = values.get(0);
        for (int i = 0; i < values.size(); i++) {
            if (comparator.compare(max, values.get(i)) > 0) {
                max = values.get(i);
            }
        }
        return max;
    }

}

class Wrapper <T> {

    private T obj;

    public Wrapper(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }
}

class Node <K, V> {
    K key;
    V value;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
