package com.gmail.chernii.oleksii.scheduled;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by Space on 20.03.2019.
 */
public class MyThread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 3;
    }
}
