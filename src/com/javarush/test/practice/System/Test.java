package com.javarush.test.practice.System;

import java.io.*;

/**
 * Created by Rostyslav.Pash on 06-Jan-16.
 */
public class Test
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        if (Integer.parseInt(reader.readLine()) >= 1 && Integer.parseInt(reader.readLine()) <= 999)
        {
            int i = Integer.parseInt(reader.readLine());

            if (i % 2 == 0 && i < 10)
            {
                System.out.println("четное однозначное число");
            } else if (i % 2 != 0 && i < 10)
            {
                System.out.println("нечетное однозначное число");
            } else if (i % 2 == 0 && i >= 10 && i < 100)
            {
                System.out.println("четное двузначное число");
            } else if (i % 2 != 0 && i >= 10 && i < 100)
            {
                System.out.println("нечетное двузначное числоо");
            } else if (i % 2 == 0 && i > 100)
            {
                System.out.println("четное трехзначное число");
            } else if (i % 2 != 0 && i > 100)
            {
                System.out.println("нечетное трехзначное число");
            }


        }
    }
}
