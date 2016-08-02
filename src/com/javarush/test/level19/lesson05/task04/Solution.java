package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));

        String file1 = reader1.readLine();
        String file2 = reader1.readLine();

        //file1 = "c:\\1.txt";
        //file2 = "c:\\2.txt";

        FileReader reader = new FileReader(file1);
        FileWriter output = new FileWriter(file2);
        while (reader.ready()) {
            int i = reader.read();
            if (i == 46) i = 33;
            output.write(i);
        }
        output.close();
        reader.close();
        reader1.close();

    }
}
