package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.BreakIterator;
import java.util.Locale;
import java.util.StringTokenizer;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String str = "";
        //напишите тут ваш код

        String newStr[] = s.split(" ");
        
        for (int i = 0; i < newStr.length; i++) {
            if (i >= 0 && i < newStr.length - 1)
                str += newStr[i].substring(0, 1).toUpperCase() + newStr[i].substring(1) + " ";
            else
                str += newStr[i].substring(0, 1).toUpperCase() + newStr[i].substring(1);
            System.out.println(str);
        }

    }


}
