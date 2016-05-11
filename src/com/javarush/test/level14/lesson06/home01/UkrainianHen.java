package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Rostyslav.Pash on 11-May-16.
 */
public class UkrainianHen extends Hen {
    @Override
    int getCountOfEggsPerMonth() {
        return 30;
    }

    String getDescription() {
        return super.getDescription() + " Моя страна - " + Country.UKRAINE + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
