package com.javarush.test.practice.System;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Rost on 11-Jun-16.
 */
public class MainClass {

    public static AtomicInteger number = new AtomicInteger(1000);

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Increment());
        thread.start();
        Thread thread2 = new Thread(new Decrement());
        thread2.start();
        thread.join();
        thread2.join();
        System.out.println(number);
    }

    public static void increment() {
        number.incrementAndGet();
    }

    public static void decrement() {
        number.decrementAndGet();
    }

    public static class Increment implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 100000; i++) {
                increment();
            }
        }
    }

    public static class Decrement implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 100000; i++) {
                decrement();
            }
        }
    }
}



