package com.gmail.chernii.oleksii.future;

import java.util.concurrent.*;

/**
 * Created by Space on 19.03.2019.
 */
public class FutureExample {
    private static String YES ="YES";
    private static String NO ="NO";

    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<String> future = service.submit(new ThreadCallable());
        System.out.println("Done? - " + ((future.isDone()) ? YES : NO));
        try {
            String result = future.get();
            System.out.println("Done? - " + ((future.isDone()) ? YES : NO));
            System.out.println("Result - " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        service.shutdown();
    }
}