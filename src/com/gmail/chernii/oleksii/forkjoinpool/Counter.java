package com.gmail.chernii.oleksii.forkjoinpool;

import java.util.concurrent.RecursiveTask;

/**
 * Created by Space on 19.03.2019.
 */
public class Counter extends RecursiveTask<Long> {
    private long from;
    private long to;

    public Counter(long from, long to) {
        this.from = from;
        this.to = to;
    }

    @Override
    protected Long compute() {
        if ((to - from) <= ForkJoinPoolExample.COUNT_OF_OPERATIONS / ForkJoinPoolExample.NUMBER_OF_THREADS) {
            long result = 0;
            for (long i = from; i < to; i++) {
                result += i;
            }
            return result;
        } else {
            long middle = (to + from) / 2;
            Counter firstHalf = new Counter(from, middle);
            firstHalf.fork();
            Counter secondHalf = new Counter(middle + 1, to);
            secondHalf.fork();
            return firstHalf.join() + secondHalf.join();
        }
    }
}
