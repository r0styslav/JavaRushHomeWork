package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream;
        FileOutputStream outputStream;
        List<Integer> intList = new ArrayList<>();
        String[] files = br.readLine().split(", ");
        boolean parne;
        int count;

        for (String file :
                files) {
            System.out.println(file);
        }

        inputStream = new FileInputStream(files[0]);
        parne = inputStream.available()%2 == 0;
        count = inputStream.available();

        while (inputStream.available() > 0) {
            if (parne)
            intList.add(inputStream.read());
        }



    }
}
