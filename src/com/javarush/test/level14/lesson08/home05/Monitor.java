package com.javarush.test.level14.lesson08.home05;

/**
 * Created by Rost on 15-May-16.
 */
public class Monitor implements CompItem {
    @Override
    public String getName() {
        return "Monitor";
        //return this.getClass().toString();
    }
    @Override
    public String toString() {
        return "Monitor";
    }
}
