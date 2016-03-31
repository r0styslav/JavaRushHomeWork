package com.javarush.test.practice.System;

import java.io.*;

/**
 * Created by Rostyslav.Pash on 06-Jan-16.
 */
public class in
{
    public static void main(String[] args)
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try
        {
            String name = reader.readLine(); //читаем строку с клавиатуры
            String sAge = reader.readLine(); //читаем строку с клавиатуры
            int nAge = Integer.parseInt(sAge); //преобразовываем строку в число.
            System.out.println("Name: " + name + " Age: " + nAge);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }



    }
}
