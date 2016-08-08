package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
        String line = "";

        while (reader.ready()) {
            line = reader.readLine();
            String[] words = line.split(" ");

            for (String word :
                    words) {
                if (word.contains("0") || word.contains("1") || word.contains("2") || word.contains("3")
                        || word.contains("4") || word.contains("5") || word.contains("6") || word.contains("7")
                        || word.contains("8") || word.contains("9")) {
                    writer.write(word + " ");
                }
            }
        }

        writer.close();
        reader.close();


    }
}
