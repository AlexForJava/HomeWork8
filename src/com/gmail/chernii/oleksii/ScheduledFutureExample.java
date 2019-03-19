package com.gmail.chernii.oleksii;

import java.util.concurrent.*;

/**
 * Created by Space on 19.03.2019.
 */
public class ScheduledFutureExample {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        Callable<Integer> callable = () -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 3;
        };
        ScheduledFuture<Integer> future = service.schedule(callable, 3, TimeUnit.SECONDS);
        ExecutorService timer = Executors.newSingleThreadExecutor();
        timer.execute(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i + 1 + "sec");
            }
        });
        try {

            int result = future.get();
            System.out.println("Result = " + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        service.shutdown();
        timer.shutdown();
    }
}
