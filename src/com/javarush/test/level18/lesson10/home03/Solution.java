package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStream outputStream = new FileOutputStream(br.readLine());
        FileInputStream inputStream1 = new FileInputStream(br.readLine());
        FileInputStream inputStream2 = new FileInputStream(br.readLine());

        // write in 1st file - > 2nd file
        while (inputStream1.available() > 0)
            outputStream.write(inputStream1.read());

        // write in 1st file -> 3rd file
        while (inputStream2.available() > 0)
            outputStream.write(inputStream2.read());

        // close all streams
        br.close();
        outputStream.close();
        inputStream1.close();
        inputStream2.close();

    }
}
