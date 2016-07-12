package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки. Не использовать try-with-resources

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        final int comma = 44;
        int count = 0;
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(br.readLine());
        while (fis.available() > 0) {
            if (fis.read() == 44)
                count++;
        }
        System.out.println(count);
        fis.close();
        br.close();
    }
}
