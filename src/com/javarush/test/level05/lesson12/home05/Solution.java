package com.javarush.test.level05.lesson12.home05;

/* Вводить с клавиатуры числа и считать их сумму
Вводить с клавиатуры числа и считать их сумму, пока пользователь не введёт слово «сумма». Вывести на экран полученную сумму.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;

        for (; ; )
        {
            String str = bufferedReader.readLine();
            if (!str.equalsIgnoreCase("сумма"))
                sum += Integer.parseInt(str);
            else
                break;
        }
        System.out.println(sum);

    }
}
