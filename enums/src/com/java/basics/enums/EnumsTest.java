package com.java.basics.enums;

import java.util.ArrayList;
import java.util.List;

public class EnumsTest {

    int fruit = Fruit.APPLE_RED;
    int fruit1 = 5;

    Apple apple = Apple.RED;

    public static void main(String[] args) {
        Cat cat = new Cat("Alice", 5, Color.WHITE);
        cat.getList(new ArrayList<String>());

        /*switch (cat.getColor()) {
            case WHITE:
                System.out.println(cat.getColor().getColorValue());
                break;
            case BLACK:
                break;
        }

        for (Color color : Color.values()) {
            System.out.println(color.getColorValue());
        }*/

        Numbers number = Numbers.FOUR;
        System.out.println(number.printOrdinal());
    }
}

class Fruit {
    public static final int APPLE_RED = 1;
    public static final int APPLE_YELLOW = 2;

    public static final int ORANGE_YELLOW = 3;
    public static final int ORANGE_WHITE = 4;
}

enum Apple {
    RED,
    YELLOW
}

enum Orange {
    YELLOW,
    WHITE
}

enum Color {
    BLACK("Black cat"),
    WHITE("White cat"),
    BLUE("Blue cat");

    private String colorValue;

    Color(String colorValue) {
        this.colorValue = colorValue;
    }

    public String getColorValue() {
        return colorValue;
    }
}

enum Numbers {
    ONE(1),
    TWO(2),
    FOUR(4);

    private int ordNumber;

    Numbers(int ordNumber) {
        this.ordNumber = ordNumber;
    }

    public int printOrdinal() {
        return ordNumber;
    }
}

class Cat {
    String name;
    int age;
    Color color;

    public Cat(String name, int age, Color color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @SuppressWarnings("unused")
    public Color getColor() {
        return color;
    }

    @SuppressWarnings("unchecked")
    public void getList(List list) {
        list.add(new Object());
    }
}