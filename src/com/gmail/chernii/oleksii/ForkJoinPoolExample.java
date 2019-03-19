package com.gmail.chernii.oleksii;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Created by Space on 19.03.2019.
 */
public class ForkJoinPoolExample {
    private static int numberOfThread = 4;
    private static long countOfOperations = 1_000_000_000;

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(numberOfThread);
        System.out.println(forkJoinPool.invoke(new Task(0, countOfOperations)));
    }

    private static class Task extends RecursiveTask<Long> {
        private long from;
        private long to;

        public Task(long from, long to) {
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
                Task firstHalf = new Task(from, middle);
                firstHalf.fork();
                Task secondHalf = new Task(middle + 1, to);
                secondHalf.fork();
                return firstHalf.join() + secondHalf.join();
            }
        }
    }
}
