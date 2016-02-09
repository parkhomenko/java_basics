package com.java.basics.threads;

public class RunnableThread {

    public static void main(String[] args) {

        MyRunnableThread myThreadClass = new MyRunnableThread();
        Thread thread = new Thread(myThreadClass);
        thread.start();

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getId() + " thread: " + i);
        }
    }
}

class MyRunnableThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getId() + " thread: " + i);
        }
    }
}