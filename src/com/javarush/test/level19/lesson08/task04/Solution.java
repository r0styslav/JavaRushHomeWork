package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream oldPrint = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream newPrint = new PrintStream(outputStream);
        System.setOut(newPrint);
        testString.printSomething();

        String result = outputStream.toString();

        System.setOut(oldPrint);
        String[] numbers = result.split(" ");
        int a = Integer.parseInt(numbers[0]);
        int b = Integer.parseInt(numbers[2]);
        if (result.contains("+"))
            System.out.println(a + " + " + b + " = " + (a + b));
        else if (result.contains("-"))
            System.out.println(a + " - " + b + " = " + (a - b));
        else if (result.contains("*"))
            System.out.println(a + " * " + b + " = " + (a * b));


    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

