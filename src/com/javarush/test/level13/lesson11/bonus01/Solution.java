package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Solution
{
    public static void main(String[] args)
    {
        // напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file;
        String line;
        ArrayList<Integer> list = new ArrayList<>();
        try {
            file = br.readLine();
            FileReader inputFile = new FileReader(file);
            //Instantiate the BufferedReader Class
            br = new BufferedReader(inputFile);
            // Read file line by line and print on the console
            while((line = br.readLine() )!= null) {
                list.add(Integer.parseInt(line));
            }
            Collections.sort(list);
            for (Integer number :
                    list) {
                if (number % 2 == 0) {
                    System.out.println(number);
                }
            }
            //Close the buffer reader
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
