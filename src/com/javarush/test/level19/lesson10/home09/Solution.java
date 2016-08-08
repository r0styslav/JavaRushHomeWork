package com.javarush.test.level19.lesson10.home09;

/* Контекстная реклама
В методе main подмените объект System.out написанной вами реадер-оберткой
Ваша реадер-обертка должна выводить на консоль контекстную рекламу после каждого второго println-а
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Рекламный текст: "JavaRush - курсы Java онлайн"

Пример вывода:
first
second
JavaRush - курсы Java онлайн
third
fourth
JavaRush - курсы Java онлайн
fifth
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();
    public static final String advertisment = "JavaRush - курсы Java онлайн";
    public static void main(String[] args) {
        String[] words;
        PrintStream oldStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream newStream = new PrintStream(outputStream);
        System.setOut(newStream);

        testString.printSomething();

        System.setOut(oldStream);
        words = outputStream.toString().split(System.lineSeparator());
        //words = outputStream.toString().split("\\r\\n");
        for (int i = 1; i <= words.length; i++) {
            System.out.println(words[i - 1]);
            if (i % 2 == 0) {
                System.out.println(advertisment);
            }
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
