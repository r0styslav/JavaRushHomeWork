package com.javarush.test.level03.lesson06.task01;

/* Мама мыла раму
Вывести на экран все возможные комбинации слов «Мама», «Мыла», «Раму».
Подсказка: их 6 штук. Каждую комбинацию вывести с новой строки. Слова не разделять. Пример:
МылаРамуМама
РамуМамаМыла
...
*/

public class Solution
{
    public static String printString(String[] string)
    {
        String temp = "";
        for (String str : string)
        {
            temp += str;
        }
        return temp;
    }

    public static void main(String[] args)
    {
        //напишите тут ваш код
        String mamaMylaRamu[] = {"Мама", "Мыла", "Раму"};
        int lenght = mamaMylaRamu.length;
        String tempLetter;
        int factorial = 1, n = 1;
        for (int i = 1; i <= lenght; i++)
        {
            factorial *= i;     // 6
        }

        for (int i = 0; i < factorial / (lenght - 1); i++) // 3
        {
            for (int j = 0; j < lenght - 1; j++) // 2
            {
                System.out.println(n++ + ": " + printString(mamaMylaRamu));
                tempLetter = mamaMylaRamu[ j ];
                mamaMylaRamu[ j ] = mamaMylaRamu[ j + 1];
                mamaMylaRamu[ j + 1] = tempLetter;

            }

        }

    }

}