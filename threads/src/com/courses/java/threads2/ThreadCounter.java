package com.courses.java.threads2;

public class ThreadCounter {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread thread = new Thread(new CounterThread(counter, true));
        Thread thread1 = new Thread(new CounterThread(counter, false));

        thread.start();
        thread1.start();

        thread.join();
        thread1.join();

        System.out.println("Counter is " + counter.getValue());
    }

}

class CounterThread implements Runnable {

    private Counter counter;
    private boolean mode;

    public CounterThread(Counter counter, boolean mode) {
        this.counter = counter;
        this.mode = mode;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            if (mode) {
                counter.increment();
            } else {
                counter.decrement();
            }
        }
    }
}

class Counter {

    private int value;

    Object lock = new Object();

    public int getValue() {
        return value;
    }

    public void increment() {
        System.out.println("asdfsdf");
        synchronized (lock) {
            value++;
        }
    }

    public void decrement() {
        synchronized (lock) {
            value--;
        }
    }

    public void nonStatic() {
        synchronized (this) {
            System.out.println("nonStatic");
        }
    }

    public static void someFunction() throws ClassNotFoundException {
        Class cls = Class.forName("Counter");
        synchronized (cls) {
            System.out.println("static function");
        }
    }
}
