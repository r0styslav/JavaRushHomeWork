package com.javarush.test.level04.lesson10.task04;

import java.io.*;

/* S-квадрат
Вывести на экран квадрат из 10х10 букв S используя цикл while.
Буквы в каждой строке не разделять.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        int num = 10, num2;
        while (num > 0)
        {
            num2 = 10;
            while (num2 > 0)
            {
                System.out.print("S");
                num2--;
            }
            System.out.println();
            num--;
        }
    }
}
