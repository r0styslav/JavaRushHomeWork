package com.javarush.test.level04.lesson07.task04;

/* Положительные и отрицательные числа
Ввести с клавиатуры три целых числа.
Вывести на экран количество положительных и количество отрицательных чисел в исходном наборе,
в следующем виде:
"количество отрицательных чисел: а", "количество положительных чисел: б",
где а, б - искомые значения.
Пример для чисел 2 5 6:
количество отрицательных чисел: 0
количество положительных чисел: 3
Пример для чисел -2 -5 6:
количество отрицательных чисел: 2
количество положительных чисел: 1
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int arr[] = new int[3];
        int poss = 0, neg = 0;
        arr[0] = Integer.parseInt(bufferedReader.readLine());
        arr[1] = Integer.parseInt(bufferedReader.readLine());
        arr[2] = Integer.parseInt(bufferedReader.readLine());

        for (int num: arr)
        {
            if (num > 0)
                poss++;
            else neg++;
        }
        System.out.printf("количество отрицательных чисел: %d\n", neg);
        System.out.printf("количество положительных чисел: %d\n", poss);
    }
}
