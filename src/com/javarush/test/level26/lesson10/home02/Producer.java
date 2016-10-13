package com.javarush.test.level26.lesson10.home02;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Rostyslav.Pash on 13.10.2016.
 */
public class Producer implements Runnable{
    ConcurrentHashMap<String, String> map;
    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; ; i++) {
                System.out.println("Some text for " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
        }
    }
}
