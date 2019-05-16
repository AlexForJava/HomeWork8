package com.gmail.chernii.oleksii.future;

import com.gmail.chernii.oleksii.utils.ThreadUtil;
import java.util.concurrent.Callable;

/**
 * Created by Space on 20.03.2019.
 */
public class ThreadCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        ThreadUtil.sleep(1000);
        return "awake";
    }
}
