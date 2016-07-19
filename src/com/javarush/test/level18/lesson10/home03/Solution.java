package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStream outputStream;
        InputStream inputStream;
        String line;
        List<String> files = new ArrayList<>();

        // read files from console
        for (int i = 0; i < 3; i++) {
            files.add(br.readLine());
        }

        // write in 1st file - > 2nd file
        inputStream = new BufferedInputStream(new FileInputStream(files.get(1)));
        outputStream = new BufferedOutputStream(new FileOutputStream(files.get(0), true));
        byte[] data = new byte[inputStream.available()];
        inputStream.read(data);
        outputStream.write(data);

        // write in 1st file -> 3rd file
        inputStream = new BufferedInputStream(new FileInputStream(files.get(2)));
        inputStream.read(data);
        outputStream.write(data);

        // close all streams
        br.close();
        outputStream.close();
        inputStream.close();

    }
}
