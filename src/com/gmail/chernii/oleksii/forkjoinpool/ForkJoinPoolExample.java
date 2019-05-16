package com.gmail.chernii.oleksii.forkjoinpool;

import java.util.concurrent.ForkJoinPool;

/**
 * Created by Space on 22.03.2019.
 */
public class ForkJoinPoolExample {
    public static final int NUMBER_OF_THREADS = 4;
    public static final long COUNT_OF_OPERATIONS = 1_000_000_000;

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(NUMBER_OF_THREADS);
        System.out.println(forkJoinPool.invoke(new Counter(0, COUNT_OF_OPERATIONS)));
    }
}
