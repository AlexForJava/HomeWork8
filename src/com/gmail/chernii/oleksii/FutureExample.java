package com.gmail.chernii.oleksii;

import java.util.concurrent.*;

/**
 * Created by Space on 19.03.2019.
 */
public class FutureExample {
    public static void main(String[] args) {
        Callable<String> task = () -> {
            TimeUnit.SECONDS.sleep(2);
            return "awake";
        };
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<String> future = service.submit(task);
        System.out.println("Done? - " + ((future.isDone()) ? "yes" : "no"));
        try {
            String result = future.get();
            System.out.println("Done? - " + ((future.isDone()) ? "yes" : "no"));
            System.out.println("Result - " + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        service.shutdown();
    }
}
