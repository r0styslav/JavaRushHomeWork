package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(br.readLine());
        FileOutputStream outputStream1 = new FileOutputStream(br.readLine());
        FileOutputStream outputStream2 = new FileOutputStream(br.readLine());
        int size = inputStream.available();
        int countOfReadingBytes;
        int firstHalf = size / 2;
        int secondHalf = size - firstHalf;

        byte[] b = new byte[inputStream.available()];

        while (inputStream.available() > 0) {
            countOfReadingBytes = inputStream.read(b);
            outputStream1.write(b, 0, firstHalf);
            outputStream2.write(b, firstHalf, secondHalf);
        }

        br.close();
        inputStream.close();
        outputStream1.close();

    }
}
