package com.gmail.chernii.oleksii.threadpoolexecutor;

import com.gmail.chernii.oleksii.utils.ThreadUtil;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by Space on 19.03.2019.
 */
public class ThreadPoolExecutorExample {
    public void start() {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        Runnable r = () -> {
            int sleep = (int) (Math.random() * 10);
            ThreadUtil.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " awake after " + sleep + " sec.");
        };
        executor.execute(r);
        executor.execute(r);

        executor.shutdown();
        executor.shutdown();
    }
}
