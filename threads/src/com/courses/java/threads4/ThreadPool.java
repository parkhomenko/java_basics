package com.courses.java.threads4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 18.02.2016.
 */
public class ThreadPool {

    private BlockingQueue queue;
    private int numberOfThreads;
    private List<ThreadInThePool> threads = new ArrayList<>();

    ThreadPool(int numberOfThreads) {
        this.numberOfThreads = numberOfThreads;
        queue = new BlockingQueue(10);

        for (int i = 0; i < numberOfThreads; i++) {
            ThreadInThePool threadInThePool = new ThreadInThePool(queue);
            threads.add(threadInThePool);
            Thread thread = new Thread(threadInThePool);
            thread.start();
        }
    }

    public void execute(Runnable task) throws InterruptedException {
        queue.addTask(task);
    }

    public void shutdown() {
        for (ThreadInThePool thread : threads) {
            thread.stop();
        }
    }
}

class ThreadInThePool implements Runnable {

    private BlockingQueue queue;
    private boolean stopped = false;

    ThreadInThePool(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (!stopped) {
            try {
                Runnable task = queue.getTask();
                task.run();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        stopped = true;
    }
}