package com.java.basics.enums;

public class SingletonTest {

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        singleton.makeSomething();

        SingletonEnum singletonEnum = SingletonEnum.INSTANCE;
        singletonEnum.makeSomething();
    }
}


class Singleton {
    private static Singleton INSTANCE = null;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton();
        }

        return INSTANCE;
    }

    public void makeSomething() {
        System.out.println("Something");
    }
}

enum SingletonEnum {
    INSTANCE;

    public void makeSomething() {
        System.out.println("Something");
    }
}
