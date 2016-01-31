package com.javarush.test.level07.lesson09.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Удвой слова
1. Введи с клавиатуры 10 слов в список строк.
2. Метод doubleValues должен удваивать слова по принципу a,b,c -> a,a,b,b,c,c.
3. Используя цикл for выведи результат на экран, каждое значение с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //Считать строки с консоли и объявить ArrayList list тут
        ArrayList<String> list = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++)
        {
            list.add(bufferedReader.readLine());
        }
        ArrayList<String> result = doubleValues(list);

        //Вывести на экран result
        for (String str :
                result)
        {
            System.out.println(str);
        }
    }

    public static ArrayList<String> doubleValues(ArrayList<String> list)
    {
        int listSize = list.size();
        //напишите тут ваш код
        for (int i = 1; i <= listSize * 2; i += 2)
        {
            list.add(i, list.get(i - 1));
        }
        return list;
    }
}
