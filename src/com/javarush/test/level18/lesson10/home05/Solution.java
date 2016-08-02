package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = bufferedReader.readLine();
        String file2 = bufferedReader.readLine();
        //String file1 = "r:\\1\\1.txt";
        //String file2 = "r:\\1\\2.txt";
        StringBuilder line = new StringBuilder();
        Scanner sc = new Scanner(new FileReader(file1));
        FileWriter outputStream = new FileWriter(file2);

        while (sc.hasNext()) {
            line.append((int) Math.round(sc.nextDouble()) + " ");
        }

        outputStream.write(line.toString());

        bufferedReader.close();
        sc.close();
        outputStream.close();




    }
}
