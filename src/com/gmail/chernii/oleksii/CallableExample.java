package com.gmail.chernii.oleksii;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

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

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        List<Future<Integer>> list = new ArrayList<>();
        list.add(service.submit(new CallableExample(10)));
        list.add(service.submit(new CallableExample(8)));

        list.forEach(e -> {
            try {
                System.out.println(e.get());
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            } catch (ExecutionException e1) {
                e1.printStackTrace();
            }
        });

        service.shutdown();
    }
}
