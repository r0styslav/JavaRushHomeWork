package com.javarush.test.level14.lesson08.home05;

/**
 * Created by Rost on 15-May-16.
 */
public class Keyboard implements CompItem {
    @Override
    public String getName() {
        //return this.getClass().toString();
        return "Keyboard";
    }
    @Override
    public String toString() {
        return "Keyboard";
    }
}
