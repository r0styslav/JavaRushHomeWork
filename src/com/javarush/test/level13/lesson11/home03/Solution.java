package com.javarush.test.level13.lesson11.home03;

/* Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть освободить ресурсы. Закрыть поток чтения с файла и поток ввода с клавиатуры.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args)
    {
        //add your code here
        String fileName;
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            fileName = br.readLine();
            //Create object of FileReader
            FileReader inputFile = new FileReader(fileName);
            //Instantiate the BufferedReader Class
            br = new BufferedReader(inputFile);
            // Read file line by line and print on the console
            while((line = br.readLine()) != null) {
                System.out.println(line);
            }
            //Close the buffer reader
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
