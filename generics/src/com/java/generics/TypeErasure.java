package com.java.generics;

import java.util.ArrayList;
import java.util.List;

public class TypeErasure {

    public static void main(String[] args) {

        //создание списка строк
        List<String> list = new ArrayList<>();

        //кастинг в нетипизированный список
        List notGenericList = list;

        //добавление объекта в список
        notGenericList.add(new Object());

        //получение объекта из списка
        Object obj = list.get(0);

        //получение строки из списка
        String str = list.get(0);
    }
}
