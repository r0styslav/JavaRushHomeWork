package com.javarush.test.level07.lesson09.task01;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Три массива
1. Введи с клавиатуры 20 чисел, сохрани их в список и рассортируй по трём другим спискам:
Число делится на 3 (x%3==0), делится на 2 (x%2==0) и все остальные.
Числа, которые делятся на 3 и на 2 одновременно, например 6, попадают в оба списка.
2. Метод printList должен выводить на экран все элементы списка с новой строки.
3. Используя метод printList выведи эти три списка на экран.
Сначала тот, который для x%3, потом тот, который для x%2, потом последний.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> arrayX2 = new ArrayList<>();
        ArrayList<Integer> arrayX3 = new ArrayList<>();
        ArrayList<Integer> arrayOther = new ArrayList<>();


        for (int i = 0; i < 20; i++)
        {
            arrayList.add(Integer.parseInt(bufferedReader.readLine()));
        }

        for (int num:
             arrayList)
        {
            if (num % 3 == 0)
            {
                arrayX3.add(num);
            }

            if (num % 2 == 0)
            {
                arrayX2.add(num);
            }

            if (num % 2 != 0 && num % 3 != 0)
            {
                arrayOther.add(num);
            }
        }

        printList(arrayX3);
        printList(arrayX2);
        printList(arrayOther);
    }

    public static void printList(List<Integer> list)
    {
        //напишите тут ваш код
        for (int num :
                list)
        {
            System.out.println(num);
        }
        //System.out.println();
    }
}
