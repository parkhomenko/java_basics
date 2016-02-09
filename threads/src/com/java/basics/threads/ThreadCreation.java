package com.java.basics.threads;

public class ThreadCreation {

    public static void main(String[] args) {

        MyThread thread = new MyThread();
        thread.start();

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getId() + " thread: " + i);
        }
    }
}

class MyThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getId() + " thread: " + i);
        }
    }
}
