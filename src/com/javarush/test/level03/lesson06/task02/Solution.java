package com.javarush.test.level03.lesson06.task02;

/* Таблица умножения
Выведи на экран таблицу умножения 10 на 10 в следующем виде:
1 2 3 …
2 4 6 …
3 6 9 …
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        int table[][] = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
        };

        for (int i = 0; i < table[0].length; i++)
        {
            for (int y = 0; y < table[1].length; y++)
            {
                System.out.print(table[0][i] * table[1][y]+ " ");
            }
            System.out.println();
        }

    }
}