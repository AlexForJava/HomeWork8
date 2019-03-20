package com.gmail.chernii.oleksii.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Space on 19.03.2019.
 */
public class ExecutorServiceExample {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(5);
        run(service);
        Thread.sleep(1000);
        ExecutorService excutor = Executors.newCachedThreadPool();
        run(excutor);
    }

    private static void run(ExecutorService service) {
        for (int i = 0; i < 5; i++) {
            service.execute(() -> System.out.println(Thread.currentThread().getName()));
        }
        service.shutdown();
    }
}
