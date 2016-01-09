package com.javarush.test.level04.lesson04.task08;

/* Треугольник
Ввести с клавиатуры три числа а, b, c – стороны предполагаемого треугольника.
Определить возможность существования треугольника по сторонам.
Результат вывести на экран в следующем виде:
"Треугольник существует." - если треугольник с такими сторонами существует.
"Треугольник не существует." - если треугольник с такими сторонами не существует.
Подсказка: Треугольник существует только тогда, когда сумма любых двух его сторон больше третьей.
Требуется сравнить каждую сторону с суммой двух других.
Если хотя бы в одном случае сторона окажется больше суммы двух других,
то треугольника с такими сторонами не существует.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        /*int a = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int b = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int c = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());*/

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a1 = reader.readLine();
        String a2 = reader.readLine();
        String a3 = reader.readLine();
        Integer a = Integer.parseInt(a1);
        Integer b = Integer.parseInt(a2);
        Integer c = Integer.parseInt(a3);

        if (a>=b+c || b>=a+c || c>=a+b)
            System.out.println("Треугольник не существует.");
        else
            System.out.println("Треугольник существует.");

    }
}