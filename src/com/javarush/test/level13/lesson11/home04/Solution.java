package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args)
    {
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String fileName = br.readLine();
            FileWriter fw = new FileWriter(fileName);
            //BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            do  {
                line = br.readLine();
                fw.write(line);
                fw.write(System.getProperty("line.separator"));
            } while (!(line).equalsIgnoreCase("exit"));

            fw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
