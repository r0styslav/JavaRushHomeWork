package com.javarush.test.level22.lesson09.task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        //fileName = "C:/1.txt";
        TreeSet<String> set = new TreeSet<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        StringBuilder sb = new StringBuilder();

        while (reader.ready()) {
            String line[] = reader.readLine().split(" ");
            for (String s : line)
                sb.append(s + " ");
        }
        reader.close();
        String[] words = sb.toString().split(" ");
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                String reversedWord = new StringBuilder(words[i]).reverse().toString();
                if (reversedWord.equals(words[j]) && !set.contains(words[j])) {
                    Pair pair = new Pair();
                    set.add(words[j]);
                    pair.first = words[j];
                    pair.second = words[i];
                    result.add(pair);
                }
            }
        }
        //for (Pair p : result) System.out.println(p);
        br.close();
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null && second != null ? second :
                            second == null && first != null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
