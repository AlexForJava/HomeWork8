package com.gmail.chernii.oleksii.forkjoinpool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Created by Space on 19.03.2019.
 */
public class ForkJoinPoolExample {
    private static final int numberOfThread = 4;
    private static final long countOfOperations = 1_000_000_000;

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(numberOfThread);
        System.out.println(forkJoinPool.invoke(new Counter(0, countOfOperations)));
    }

    private static class Counter extends RecursiveTask<Long> {
        private long from;
        private long to;

        public Counter(long from, long to) {
            this.from = from;
            this.to = to;
        }

        @Override
        protected Long compute() {
            if ((to - from) <= countOfOperations / numberOfThread) {
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
}
