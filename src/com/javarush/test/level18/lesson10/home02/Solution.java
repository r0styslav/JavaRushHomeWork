package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);
        byte space = " ".getBytes()[0];
        byte[] array = new byte[inputStream.available()];
        int size = inputStream.read(array), spaceCount = 0;

        for (byte b :
                array) {
            if (b == space) {
                spaceCount++;
            }
        }

        System.out.println(String.format("%.2f", (double)spaceCount/size*100));

        inputStream.close();
    }
}
