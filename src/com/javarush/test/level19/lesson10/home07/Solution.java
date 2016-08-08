package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        //BufferedReader reader = new BufferedReader(new FileReader("r:\\1\\1.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
        //BufferedWriter writer = new BufferedWriter(new FileWriter("r:\\1\\2.txt"));
        int j = 0;
        while (reader.ready()) {
            String[] words = reader.readLine().split(" ");

            for (int i = 0; i < words.length; i++) {
                if (words[i].length() > 6) {
                    if (j == 0)
                        writer.write(words[i]);
                    else
                        writer.write("," + words[i]);
                    j++;
                }
            }
        }

        writer.close();
        reader.close();

    }
}
