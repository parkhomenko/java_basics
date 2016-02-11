package com.courses.java.threads2;

public class ThreadSleepExample {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());

        Thread thread = new Thread(new MyThread());
        thread.setName("MyThread");

        Thread thread1 = new Thread(new MyThread());
        thread1.setName("My New Thread");

        thread.start();
        thread1.start();

        thread.join();
        thread1.join();

        System.out.println(Thread.currentThread().getName());
    }

    public static void createMyThread() throws InterruptedException {
        Thread thread = new Thread(new MyThread());
        thread.setName("MyThread");
        thread.start();

        thread.join();
    }
}

class MyThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.yield();
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}