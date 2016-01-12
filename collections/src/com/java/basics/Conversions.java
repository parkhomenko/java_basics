package com.java.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Conversions {

    public static void main(String[] args) {

        //создание списка и заполнение его элементами
        List<String> linkedList = new LinkedList<>();
        linkedList.add("first");
        linkedList.add("second");
        linkedList.add("third");

        //вывод списка в консоль
        System.out.println(linkedList);

        //конвертация LinkedList в ArrayList
        List<String> arrayList = new ArrayList<>(linkedList);

        //вывод полученного ArrayList в консоль
        System.out.println(arrayList);

        //создание массива строк
        String[] array = new String[] {"first", "second", "third"};

        //конвертация массива в LinkedList
        //функция Arrays.asList(array) конвертирует массив в ArrayList
        //после ArrayList преобразовывается в LinkedList
        List<String> linkedList2 = new ArrayList<>(Arrays.asList(array));

        //вывод полученного LinkedList в консоль
        System.out.println(linkedList2);
    }
}
