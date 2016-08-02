package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File file1 = new File(reader.readLine());
        File file2 = new File(reader.readLine());
        //file1 = new File("r:\\1\\1.txt");
        //file2 = new File("r:\\1\\2.txt");
        FileWriter outputStream = new FileWriter(file2);
        BufferedReader fileReader = new BufferedReader(new FileReader(file1));
        StringBuilder number = new StringBuilder();

        while (fileReader.ready()) {
            String line = fileReader.readLine();
            String[] words = line.split(" ");
            for (String str :
                    words) {
                try {
                    Integer.parseInt(str);
                    number.append(str + " ");
                } catch (Exception e) {
                }
            }
        }
        outputStream.write(number.toString());

        reader.close();
        outputStream.close();
        fileReader.close();


    }
}
