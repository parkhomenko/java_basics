package com.courses.java.threads2;

public class ThreadInterruption {

    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadSample());
        thread.start();

        Thread thread1 = new Thread(new ThreadSample());
        thread1.start();

        thread.interrupt();

        System.out.println("Main has finished");
    }
}

class ThreadSample implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(Thread.currentThread().getName() + " " + i);
                if (Thread.currentThread().isInterrupted())
                    return;
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " finished");
    }
}