package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
*/

import java.io.*;

public class Solution
{
    public static boolean max(int a1, int a2)
    {
        return a1 < a2 ;
    }
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int array[] = new int[3];
        array[0] = Integer.parseInt(bufferedReader.readLine());
        array[1] = Integer.parseInt(bufferedReader.readLine());
        array[2] = Integer.parseInt(bufferedReader.readLine());
        int temp[] = array;
        int max;

        for (int k = 0; k < 2; k++)
        for (int i = 0; i < 2; i++)
        {
            if (max(array[i],array[i + 1]))
            {
                max = array[i + 1];
                array[i + 1] = array[i];
                array[i] = max;
            }
        }

        for (int i: array)
        {
            System.out.println(i +" ");

        }

    }
}
