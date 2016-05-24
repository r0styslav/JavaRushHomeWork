package com.javarush.test.level15.lesson12.home04;

/**
 * Created by Rostyslav.Pash on 18-May-16.
 */
public class Earth implements Planet{
    private static Earth instance;

    private Earth(){}

    public static synchronized Earth getInstance(){
        if(instance == null){
            instance = new Earth();
        }
        return instance;
    }
}
