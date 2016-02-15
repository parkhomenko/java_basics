package com.courses.java.threads3;

import java.util.concurrent.CopyOnWriteArrayList;

public class DeadlockExample implements Runnable {

    static Resource resA = new Resource();
    static Resource resB = new Resource();

    boolean mode = true;

    public int readResource() throws InterruptedException {
        synchronized (resA) {
            Thread.sleep(1000);
            synchronized (resB) {
                return resA.getRes() + resB.getRes();
            }
        }
    }

    public void writeResource(int a, int b) throws InterruptedException {
        synchronized (resB) {
            Thread.sleep(1000);
            synchronized (resA) {
                resA.setRes(a);
                resB.setRes(b);
            }
        }
    }

    public static void main(String[] args) {
        DeadlockExample deadlockExample = new DeadlockExample();
        deadlockExample.mode = true;

        DeadlockExample deadlockExample1 = new DeadlockExample();
        deadlockExample1.mode = false;

        Thread thread1 = new Thread(deadlockExample);
        Thread thread2 = new Thread(deadlockExample1);

        thread1.start();
        thread2.start();
    }

    @Override
    public void run() {
        if (mode) {
            try {
                readResource();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            try {
                writeResource(5, 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Resource {
    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    int res = 0;
}