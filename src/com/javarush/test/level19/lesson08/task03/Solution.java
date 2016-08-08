package com.javarush.test.level19.lesson08.task03;

/* Выводим только цифры
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить только цифры
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток
Вывести модифицированную строку в консоль.

Пример вывода:
12345678
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream oldStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream newStream = new PrintStream(outputStream);
        System.setOut(newStream);
        testString.printSomething();

        Pattern p = Pattern.compile("\\d+");
        String result = outputStream.toString();
        String s = "";
        Matcher m = p.matcher(result);
        while (m.find()) {
            s += m.group();
        }
        System.setOut(oldStream);

        System.out.println(s);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
