package com.javarush.test.level04.lesson04.task05;

/* Положительное и отрицательное число
Ввести с клавиатуры число.
Если число положительное, то увеличить его в два раза.
Если число отрицательное, то прибавить единицу.
Вывести результат на экран.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        int number = Integer.parseInt(new BufferedReader(
                new InputStreamReader(System.in)).readLine());
        if (number < 0)
            number++;
        else
            number *= 2;
        System.out.println(number);

    }

}