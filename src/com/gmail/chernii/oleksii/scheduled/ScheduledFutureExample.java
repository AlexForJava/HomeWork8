package com.gmail.chernii.oleksii.scheduled;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ExecutionException;

/**
 * Created by Space on 19.03.2019.
 */
public class ScheduledFutureExample {
    public void start() {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        ScheduledFuture<Integer> future = service.schedule(new MyThread(), 3, TimeUnit.SECONDS);
        ExecutorService timer = Executors.newSingleThreadExecutor();
        timer.execute(new MyTimer());
        try {
            int result = future.get();
            System.out.println("Result = " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        service.shutdown();
        timer.shutdown();
    }
}
