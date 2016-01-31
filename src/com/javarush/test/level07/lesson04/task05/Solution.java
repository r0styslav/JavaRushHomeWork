package com.javarush.test.level07.lesson04.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Один большой массив и два маленьких
1. Создать массив на 20 чисел.
2. Ввести в него значения с клавиатуры.
3. Создать два массива на 10 чисел каждый.
4. Скопировать большой массив в два маленьких: половину чисел в первый маленький, вторую половину во второй маленький.
5. Вывести второй маленький массив на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int array[] = new int[20];
        int array1[] = new int[10];
        int array2[] = new int[10];
        boolean full = false;
        for (int i = 0; i < 20; i++)
        {
            array[i] = Integer.parseInt(bufferedReader.readLine());
        }

        for (int k = 0, j = 0; j < 20; k++, j++)
        {
            if (!full)
            {
                array1[k] = array[j];
                if ( k < 9) full = false;
                else
                {
                    full = true;
                    k = -1;
                }
            } else
                array2[k] = array[j];
        }

        for (int num :
                array2)
        {
            System.out.println(num);
        }


    }
}
