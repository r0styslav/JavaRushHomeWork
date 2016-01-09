package com.javarush.test.level04.lesson07.task03;

/* Положительные числа
Ввести с клавиатуры три целых числа.
Вывести на экран количество положительных чисел в исходном наборе.
Пример для чисел -4 6 6:
2
Пример для чисел -6 -6 -3:
0
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int arr[] = new int[3];
        int count = 0;
        arr[0] = Integer.parseInt(bufferedReader.readLine());
        arr[1] = Integer.parseInt(bufferedReader.readLine());
        arr[2] = Integer.parseInt(bufferedReader.readLine());

        for (int num: arr)
        {
            if (num > 0)
                count++;
        }
        System.out.println(count);
    }
}
