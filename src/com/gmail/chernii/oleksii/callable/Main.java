package com.gmail.chernii.oleksii.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Space on 20.03.2019.
 */
public class Main {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        List<Future<Integer>> list = new ArrayList<>();
        list.add(service.submit(new CallableExample(10)));
        list.add(service.submit(new CallableExample(8)));

        list.forEach(x -> {
            try {
                System.out.println(x.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });

        service.shutdown();
    }
}
