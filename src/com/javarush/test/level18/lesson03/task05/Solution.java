package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;




/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Set<Integer> integerSet = new TreeSet<>();
        FileInputStream fileInputStream = new FileInputStream(
                new BufferedReader(
                        new InputStreamReader(System.in))
                        .readLine());

        while (fileInputStream.available() > 0) {
            integerSet.add(fileInputStream.read());
        }

        for (Integer number :
                integerSet) {
            System.out.print(number + " ");
        }

        fileInputStream.close();

    }
}