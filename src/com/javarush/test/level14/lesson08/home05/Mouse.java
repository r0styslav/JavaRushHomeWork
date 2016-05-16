package com.javarush.test.level14.lesson08.home05;

/**
 * Created by Rost on 15-May-16.
 */
public class Mouse implements CompItem {
    @Override
    public String getName() {
        //return this.getClass().toString();
        return "Mouse";
    }
    @Override
    public String toString() {
        return "Mouse";
    }
}
