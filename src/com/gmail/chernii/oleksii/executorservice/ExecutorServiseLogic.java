package com.gmail.chernii.oleksii.executorservice;

import com.gmail.chernii.oleksii.utils.ThreadUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Space on 22.03.2019.
 */
public class ExecutorServiseLogic {
    public void start() {
        ExecutorService service = Executors.newFixedThreadPool(5);
        run(service);
        ThreadUtil.sleep(1000);
        ExecutorService excutor = Executors.newCachedThreadPool();
        run(excutor);
    }

    private void run(ExecutorService service) {
        for (int i = 0; i < 5; i++) {
            service.execute(() -> System.out.println(Thread.currentThread().getName()));
        }
        service.shutdown();
    }
}
