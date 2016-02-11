package com.courses.java.threads2;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {

    public static void main(String[] args) throws InterruptedException {
        Counter2 counter = new Counter2();

        Thread thread = new Thread(new AtomicCounterThread(counter, true));
        Thread thread1 = new Thread(new AtomicCounterThread(counter, false));

        thread.start();
        thread1.start();

        thread.join();
        thread1.join();

        System.out.println("Counter is " + counter.getValue());
    }

}

class AtomicCounterThread implements Runnable {

    private Counter2 counter;
    private boolean mode;

    public AtomicCounterThread(Counter2 counter, boolean mode) {
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

class Counter2 {

    AtomicInteger value = new AtomicInteger();

    public int getValue() {
        return value.intValue();
    }

    public void increment() {
        value.incrementAndGet();
    }

    public void decrement() {
        value.decrementAndGet();
    }
}
