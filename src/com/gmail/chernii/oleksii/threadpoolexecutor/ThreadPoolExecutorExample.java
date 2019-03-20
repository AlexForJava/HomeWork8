package com.gmail.chernii.oleksii.threadpoolexecutor;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Space on 19.03.2019.
 */
public class ThreadPoolExecutorExample {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        Runnable r = () -> {
            try {
                int sleep = (int) (Math.random() * 10);
                TimeUnit.SECONDS.sleep(sleep);
                System.out.println(Thread.currentThread().getName() + " awake after " + sleep + " sec.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        executor.execute(r);
        executor.execute(r);

        executor.shutdown();
        executor.shutdown();

    }
}
