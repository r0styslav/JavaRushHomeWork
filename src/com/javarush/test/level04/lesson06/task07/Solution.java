package com.javarush.test.level04.lesson06.task07;

/* Три числа
Ввести с клавиатуры три целых числа. Одно из чисел отлично от двух других, равных между собой.
Вывести на экран порядковый номер числа, отличного от остальных.
Пример для чисел 4 6 6:
1
Пример для чисел 6 6 3:
3
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        int a[] = new int[3];
        int diff;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int a1 = Integer.parseInt(bufferedReader.readLine());
        int a2= Integer.parseInt(bufferedReader.readLine());
        int a3 = Integer.parseInt(bufferedReader.readLine());
        if (a1 == a3)
            System.out.println(2);
        else if (a2 == a3)
            System.out.println(1);
        else if (a1 == a2)
            System.out.println(3);


    }
}
