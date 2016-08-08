package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, включая символы новой строки. Результат вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File fileIn = new File(reader.readLine());
        //File fileIn = new File("r:\\1\\1.txt");
        File fileOut = new File(reader.readLine());
        //File fileOut = new File("r:\\1\\2.txt");

        BufferedReader inputStream = new BufferedReader(new FileReader(fileIn));
        FileWriter outputSteam = new FileWriter(fileOut);

        String file = "";

        while (inputStream.ready()) {
            file += inputStream.readLine();
        }

        file = file.replaceAll("\\p{Punct}+", "");
        file = file.replaceAll("\n", "");

        outputSteam.write(file);

        outputSteam.close();
        inputStream.close();
        reader.close();

    }
}
