package com.gmail.chernii.oleksii.scheduled;

import java.util.concurrent.TimeUnit;

/**
 * Created by Space on 20.03.2019.
 */
public class MyTimer implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i + 1 + "sec");
        }
    }
}
