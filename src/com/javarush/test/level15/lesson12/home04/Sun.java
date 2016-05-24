package com.javarush.test.level15.lesson12.home04;

/**
 * Created by Rostyslav.Pash on 18-May-16.
 */
public class Sun implements Planet {
    private static Sun instance;

    private Sun(){}

    public static synchronized Sun getInstance(){
        if(instance == null){
            instance = new Sun();
        }
        return instance;
    }
}
