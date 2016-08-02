package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file1 = br.readLine();
        //String file1 = "r:\\1\\1.txt";
        String file2 = br.readLine();
        //String file2 = "r:\\1\\2.txt";
        FileInputStream fis = new FileInputStream(file1);
        FileOutputStream fos = new FileOutputStream(file2);
        int count = 1;

        while (fis.available() > 0) {
            if (count % 2 == 0)
                fos.write(fis.read());
            else
                fis.read();
            count++;
        }

        br.close();
        fis.close();
        fos.close();
    }
}
