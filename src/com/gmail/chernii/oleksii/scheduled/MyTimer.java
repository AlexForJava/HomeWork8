package com.gmail.chernii.oleksii.scheduled;

import com.gmail.chernii.oleksii.utils.ThreadUtil;


/**
 * Created by Space on 20.03.2019.
 */
public class MyTimer implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            ThreadUtil.sleep(1000);
            System.out.println(i + 1 + "sec");
        }
    }
}
