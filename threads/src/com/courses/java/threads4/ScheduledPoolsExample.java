package com.courses.java.threads4;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by User on 18.02.2016.
 */
public class ScheduledPoolsExample {

    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(4);
//        service.schedule(new Task(), 3, TimeUnit.SECONDS);
        service.scheduleWithFixedDelay(new Task(), 3, 2, TimeUnit.SECONDS);
        service.scheduleAtFixedRate(new Task(), 3, 2, TimeUnit.SECONDS);
//        service.shutdown();
    }
}
