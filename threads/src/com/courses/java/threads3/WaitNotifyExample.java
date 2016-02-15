package com.courses.java.threads3;

import sun.awt.windows.ThemeReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class WaitNotifyExample {

    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();
        Thread thread = new Thread(new Reader(counter));
        Thread thread2 = new Thread(new Reader(counter));
        Thread thread3 = new Thread(new Reader(counter));

        thread.start();
        thread2.start();
        thread3.start();

        SomeThread someThread = new SomeThread(counter);
        Thread threadCalculator = new Thread(someThread);

        threadCalculator.start();

        threadCalculator.join();
    }
}

class Reader implements Runnable {

    Counter counter;

    Reader(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        synchronized (counter) {
            try {
                counter.wait();
                System.out.println(Thread.currentThread().getName() + " " + counter.count);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Counter {
    int count = 0;

    List list = Collections.synchronizedList(new ArrayList());
}

class SomeThread implements Runnable {

    Counter counter;

    SomeThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (counter) {
            for (int i = 0; i < 100; i++) {
                counter.count += i;
            }
            counter.notifyAll();
//            while (true) {}
        }
    }
}