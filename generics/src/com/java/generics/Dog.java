package com.java.generics;

public class Dog {

    int age;
    String name;

    public Dog(int age, String name) {
        this.age = 5;
        this.name = "Fluffy";
    }

    public String getName() {
        return name;
    }

    public void voice() throws Exception {
        try {
            throw new Exception("adsfsadfds");
        } catch (Exception e) {
            throw new Exception("Exception is thrown");
        }
    }

    @Override
    public String toString() {
        return "Dog{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
