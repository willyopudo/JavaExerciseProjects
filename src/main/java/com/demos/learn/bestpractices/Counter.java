package com.demos.learn.bestpractices;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private AtomicInteger count = new AtomicInteger(0);
    public synchronized void increment() {
        count.incrementAndGet();
    }
    public int getCount() {
        return count.get();
    }
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        Counter counter = new Counter();
        for (int i = 0; i < 1000; i++) {
            executor.submit(counter::increment);
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, java.util.concurrent.TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
        System.out.println("Final count (with AtomicInteger): " + counter.getCount());

    }
}
