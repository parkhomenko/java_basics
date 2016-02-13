package com.courses.java.threads2;

public class ThreadedCounting {



    public static void main(String[] args) {
        Object object = new Object();
        countInThreads(object);
    }

    public static void countInThreads(Object counter) {
        Thread th1 = new Thread(new Counting(counter, 0));
        Thread th2 = new Thread(new Counting(counter, 1));
        Thread th3 = new Thread(new Counting(counter, 2));

        th1.start();
        th2.start();
        th3.start();
        try {
            th1.join();
            th2.join();
            th3.join();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Counting implements Runnable {

    int shift;
    Object counter;

    volatile static byte block = 0;

    volatile static boolean first;
    volatile static boolean second;

    Counting(Object counter, int shift) {
        this.counter = counter;
        this.shift = shift;
    }

    @Override
    public void run() {
        for (int i = 1 + shift; i <= 100; i += 3) {
            if (shift == 0) {
                while (block != 0) {}
                System.out.println(i);
                block = 1;
            }

            if (shift == 1) {
                while (block != 1) {}
                System.out.println(i);
                block = 2;
            }

            if (shift == 2) {
                while (block != 2) {}
                System.out.println(i);
                block = 0;
            }
        }
    }
}