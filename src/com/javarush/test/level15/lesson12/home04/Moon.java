package com.javarush.test.level15.lesson12.home04;

/**
 * Created by Rostyslav.Pash on 18-May-16.
 */
public class Moon implements Planet {
    private static Moon instance;

    private Moon(){}

    public static synchronized Moon getInstance(){
        if(instance == null){
            instance = new Moon();
        }
        return instance;
    }
}
