package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        //add your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        URL url = null;
        String consoleUrl = "";
        List<String> parameters = new ArrayList<>();
        try {
            consoleUrl = br.readLine();
            url = new URL(consoleUrl);
        } catch (IOException e) {
            System.out.println("Wrong url format");
            e.printStackTrace();
        }
        parameters = new ArrayList<>(Arrays.asList(url.getQuery().split("&")));
        for (String str :
                parameters) {
            System.out.print(str.split("=")[0] + " ");
        }
        System.out.println();
        for (String str :
                parameters) {
            if (str.split("=")[0].equalsIgnoreCase("obj")) {
                try {
                    alert(Double.parseDouble(str.split("=")[1]));
                } catch (NumberFormatException e) {
                    alert(str.split("=")[1]);
                }
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
