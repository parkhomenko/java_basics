package com.courses.java.threads4;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * Created by User on 18.02.2016.
 */
public class ForkExample {

    public static void main(String[] args) {
        int[] array = new int[100];
        array[1] = 45;
        array[33] = 50;
        array[78] = 5;
        ForkJoinPool pool = new ForkJoinPool();
        RecursiveActionTask task = new RecursiveActionTask(array, 0, array.length);
        int sum = pool.invoke(task);
        System.out.println(sum);
    }
}

class RecursiveActionTask extends RecursiveTask<Integer> {

    private int[] array;
    private int start;
    private int end;

    RecursiveActionTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end - start <= 25) {
            int sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            return sum;
        } else {
            int middle = ((end - start) / 2) + start;
            RecursiveActionTask left = new RecursiveActionTask(array, start, middle);
            left.fork();
            RecursiveActionTask right = new RecursiveActionTask(array, middle, end);
            int sum1 = right.compute();
            int sum2 = left.join();
            return sum1 + sum2;
        }
    }
}