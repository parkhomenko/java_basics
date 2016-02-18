package com.courses.java.threads4;

import java.util.concurrent.*;

/**
 * Created by User on 18.02.2016.
 */
public class CallableExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(4);
        Future<Integer> future = service.submit(new AnotherTask());
        int sum = future.get();
        System.out.println(sum);
    }
}

class AnotherTask implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += i;
        }
        return sum;
    }
}
