package com.javarush.test.level06.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
Пример ввода:
3
2
15
6
17
Пример вывода:
2
3
6
15
17
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int mass[] = new int[5];
        int tempVar;
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));

        //напишите тут ваш код
        for (int i = 0; i < 5; i++)
        {
            mass[i] = Integer.parseInt(reader.readLine());
        }

        for (int k = 0; k < mass.length - 1; k++)
        {

            for (int i = 0; i < mass.length - 1; i++)
            {
                if (mass[i] > mass[i + 1])
                {
                    tempVar = mass[i + 1];
                    mass[i + 1] = mass[i];
                    mass[i] = tempVar;
                }
            }
        }

        for (int a: mass)
        {
            System.out.println(a);
        }
    }
}
