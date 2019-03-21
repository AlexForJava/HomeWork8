package com.gmail.chernii.oleksii.utils;

/**
 * Created by Space on 22.03.2019.
 */
public class ThreadUtil {
    public static void sleep(long miliis){
        try {
            Thread.sleep(miliis);
        } catch (InterruptedException e) {
            System.out.println("Log message: " + e.getMessage());
        }
    }
}
