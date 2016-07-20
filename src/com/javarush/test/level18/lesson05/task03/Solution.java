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
        byte[] buffer1 = new byte[inputStream.available() / 2 + inputStream.available() % 2];
        byte[] buffer2 = new byte[inputStream.available() - buffer1.length];
        outputStream1.write(buffer1, 0, inputStream.read(buffer1));
        outputStream2.write(buffer2, 0, inputStream.read(buffer2));
        br.close();
        inputStream.close();
        outputStream1.close();
        outputStream2.close();

    }
}
