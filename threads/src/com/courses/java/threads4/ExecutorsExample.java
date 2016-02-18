package com.courses.java.threads4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by User on 18.02.2016.
 */
public class ExecutorsExample {

    public static void main(String[] args) {

        Runtime runtime = Runtime.getRuntime();
        int cpus = runtime.availableProcessors();

        System.out.println("Available processors: " + cpus);

        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(new Task());
        service.execute(new Task());
        service.execute(new Task());
        service.execute(new Task());
        service.execute(new Task());
        service.execute(new Task());
        service.execute(new Task());
        service.execute(new Task());
        service.shutdown();

    }
}
