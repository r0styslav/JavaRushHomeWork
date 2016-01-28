package com.javarush.test.level07.lesson04.task02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.BufferOverflowException;

/* Массив из строчек в обратном порядке
1. Создать массив на 10 строчек.
2. Ввести с клавиатуры 8 строчек и сохранить их в массив.
3. Вывести содержимое всего массива (10 элементов) на экран в обратном порядке. Каждый элемент - с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        String array[] = new String[10];
        String arrayBack[] = new String[10];
        int numberCount = 8;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < numberCount; i++)
        {
            array[i] = bufferedReader.readLine();
        }

        for (int i = 0; i < array.length; i++)
        {
            arrayBack[i] = array[array.length - i - 1];
        }


        for (String value : arrayBack)
        {
            System.out.println(value);
        }

    }
}