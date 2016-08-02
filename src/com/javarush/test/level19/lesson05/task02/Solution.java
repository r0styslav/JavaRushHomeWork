package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file = br.readLine();
        //String file = "r:\\1\\1.txt";
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String lines = "";
        int count = 0;
        while (reader.ready()) {
            lines = reader.readLine();
            //System.out.println("line- " + lines);
            lines = lines.replaceAll("\\p{Punct}", " ");

            //System.out.println("line after replace: " + lines);
            //String[] words = lines.split(" world ");
            String[] words = lines.split(" ");
            for (String word :
                    words) {
                //System.out.println("word - " + word);
                if (word.equals("world")) {
                    count++;
                }
                //System.out.println("count - " + count);
            }
        }

        System.out.println(count);
        br.close();
        reader.close();
    }
}
