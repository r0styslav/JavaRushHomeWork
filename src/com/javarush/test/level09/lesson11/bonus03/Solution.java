package com.javarush.test.level09.lesson11.bonus03;

import com.sun.org.apache.xerces.internal.impl.dv.xs.BooleanDV;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/* Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел). Слова вывести в возрастающем порядке, числа - в убывающем.
Пример ввода:
Вишня
1
Боб
3
Яблоко
2
0
Арбуз
Пример вывода:
Арбуз
3
Боб
2
Вишня
1
0
Яблоко
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true)
        {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(String[] array)
    {
        ArrayList<Integer> intArray = new ArrayList<>();
        ArrayList<String> strArray = new ArrayList<>();
        ArrayList<Integer> numberPosition = new ArrayList<>();
        ArrayList<Integer> stringPosition = new ArrayList<>();
        Boolean[] isString = new Boolean[array.length];
        int k = 0, y = 0;

        //напишите тут ваш код
        for (int i = 0; i < array.length; i++) {
            if (isNumber(array[i])) {
                intArray.add(Integer.parseInt(array[i]));
                isString[i] = false;
            } else
            {
                strArray.add(array[i]);
                isString[i] = true;
            }
        }

        Collections.sort(intArray, Collections.<Integer>reverseOrder());
        Collections.sort(strArray);

        for (int i = 0; i < array.length; i++) {
            if (isString[i]) {
                array[i] = strArray.get(k++);
            } else {
                array[i] = intArray.get(y++).toString();
            }
        }

        //System.out.println(intArray);
        //System.out.println(strArray);
    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b)
    {
        return a.compareTo(b) > 0;
    }


    //строка - это на самом деле число?
    public static boolean isNumber(String s)
    {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            char c = chars[i];
            if ((i != 0 && c == '-') //есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-') ) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
