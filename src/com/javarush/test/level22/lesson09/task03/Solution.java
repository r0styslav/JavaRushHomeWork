package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //...
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(br.readLine()));
        String str = "";
        while (reader.ready()) {
            str += reader.readLine() + " ";
        }

        StringBuilder result = getLine(str.split(" "));
        System.out.println(result.toString());
        br.close();
        reader.close();
    }

    public static StringBuilder getLine(String... words) {
        if (words == null || words.length == 0)
            return new StringBuilder();
        if ("".equals(words[0]) || words.length == 1)
            return new StringBuilder(words[0]);
        boolean exit = false;
        List<String> list = new ArrayList<>(Arrays.asList(words));
        StringBuilder sb = new StringBuilder();

        while (!exit) {
            Collections.shuffle(list);
            exit = true;
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i).toLowerCase().charAt(list.get(i).length() - 1) != list.get(i + 1).toLowerCase().charAt(0)) {
                    exit = false;
                    break;
                }
            }
        }
        sb.append(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            sb.append(" " + list.get(i));
        }
        return sb;
    }


}
