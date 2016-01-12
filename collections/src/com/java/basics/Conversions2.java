package com.java.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Conversions2 {

    List<String> list;
    String[] array;

    public static void main(String[] args) {
        Conversions2 conv = new Conversions2();

        conv.createLinkedList();
        conv.linkedListToArrayList();

        conv.createArray();
        conv.arrayToLinkedList();
    }

    public void createLinkedList() {
        list = new LinkedList<>();
        list.add("first");
        list.add("second");
        list.add("third");
    }

    public void createArray() {
        array = new String[3];
        array[0] = "first in array";
        array[1] = "second in array";
        array[2] = "third in array";
    }

    public void linkedListToArrayList() {
        List<String> arrayList = new ArrayList<>(list);
        System.out.println(arrayList);
    }

    public void arrayToLinkedList() {
        List<String> arrayList = Arrays.asList(array);
        List<String> linkedList = new LinkedList<>(arrayList);
        System.out.println(linkedList);
    }
}
