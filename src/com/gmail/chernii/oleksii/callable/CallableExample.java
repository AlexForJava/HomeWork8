package com.gmail.chernii.oleksii.callable;


import java.util.concurrent.Callable;

/**
 * Created by Space on 19.03.2019.
 */
public class CallableExample implements Callable<Integer> {
    private int count;

    public CallableExample(int count) {
        this.count = count;
    }

    @Override
    public Integer call() throws Exception {
        int result = 0;
        for (int i = 0; i <= count; i++) {
            Thread.sleep(100);
            result += i;
        }
        return result;
    }

}
