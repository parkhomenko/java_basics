package com.courses.java.threads4;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by User on 18.02.2016.
 */
public class BlockingQueue {

    private Queue<Runnable> tasks;
    private int maxSize;

    public BlockingQueue(int maxSize) {
        tasks = new LinkedList<>();
        this.maxSize = maxSize;
    }

    public synchronized void addTask(Runnable task) throws InterruptedException {
        while (tasks.size() >= maxSize) {
            wait();
        }

        tasks.offer(task);

        notifyAll();
    }

    public synchronized Runnable getTask() throws InterruptedException {
        while (tasks.isEmpty()) {
            wait();
        }

        Runnable task = tasks.poll();

        notifyAll();

        return task;
    }

}
