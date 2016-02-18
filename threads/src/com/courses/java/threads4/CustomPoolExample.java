package com.courses.java.threads4;

public class CustomPoolExample {

    public static void main(String[] args) throws InterruptedException {
        ThreadPool threadPool = new ThreadPool(4);
        threadPool.execute(new Task());
        threadPool.execute(new Task());
        threadPool.execute(new Task());
        threadPool.execute(new Task());
        threadPool.execute(new Task());
        threadPool.execute(new Task());
        threadPool.execute(new Task());
        threadPool.execute(new Task());
        threadPool.shutdown();
    }
}

class Task implements Runnable {

    @Override
    public void run() {
        int sum = 0;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 10; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}