package com.javarush.test.level14.lesson08.home09;

/**
 * Created by Rost on 16-May-16.
 */
public class Hrivna extends Money {

    public Hrivna(double amount) {
        super(amount);
    }

    @Override
    public String getCurrencyName() {
        return "HRN";
    }
}
