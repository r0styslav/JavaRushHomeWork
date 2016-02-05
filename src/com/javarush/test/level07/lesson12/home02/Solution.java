package com.javarush.test.level07.lesson12.home02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Переставить M первых строк в конец списка
Ввести с клавиатуры 2 числа N  и M.
Ввести N строк и заполнить ими список.
Переставить M первых строк в конец списка.
Вывести список на экран, каждое значение с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int arraySize = 0, numFirstElements = 0;
        ArrayList<String> arrayList = new ArrayList<>();
        //напишите тут ваш код
        arraySize = Integer.parseInt(reader.readLine());
        numFirstElements = Integer.parseInt(reader.readLine());

        for (int i = 0; i < arraySize; i++)
        {
            arrayList.add(reader.readLine());
        }

        for (int i = 0; i < numFirstElements; i++)
        {
            arrayList.add(arrayList.size(), arrayList.get(0));
            arrayList.remove(0);
        }

        for (String str :
                arrayList)
        {
            System.out.println(str);
        }
    }
}
