package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String a = r.readLine();
        String b = r.readLine();
        RandomAccessFile file1 = new RandomAccessFile(a, "rw");
        RandomAccessFile file2 = new RandomAccessFile(b, "r");

        byte[] buffer1 = new byte[(int) file1.length()];
        byte[] buffer2 = new byte[(int) file2.length()];
        file2.read(buffer2);
        file1.read(buffer1);
        file1.seek(0);
        file1.write(buffer2);
        file1.write(buffer1);
        file1.close();
        file2.close();
        r.close();



        /*BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter writer;
        //String file1 = "r:\\1\\1.txt";//reader.readLine();
        String file1 = reader.readLine();
        //String file2 = "r:\\1\\2.txt";//reader.readLine();
        String file2 = reader.readLine();

        FileInputStream inputStream1 = new FileInputStream(file1);
        FileInputStream inputStream2 = new FileInputStream(file2);

        byte[] byte1 = new byte[inputStream1.available()];
        byte[] byte2 = new byte[inputStream2.available()];

        inputStream1.read(byte1);
        inputStream2.read(byte2);

        reader.close();
        inputStream1.close();
        inputStream2.close();

        FileOutputStream outputStream = new FileOutputStream(file1, false);
        outputStream.write(byte2);
        outputStream = new FileOutputStream(file1, true);
        outputStream.write(byte1);

        outputStream.close();

//*************************************************

        */

        //String file2 = reader.readLine();
        //String line;
        //String fileLine = "";
        //RandomAccessFile file = new RandomAccessFile(file1, "rw");

/*        reader = new BufferedReader(new FileReader(file2));
        while ((line = reader.readLine()) != null) {
            fileLine += line;
        }*/
/*        reader = new BufferedReader(new FileReader(file1));
        while ((line = reader.readLine()) != null) {
            fileLine += line;
        }*/
        //reader.close();
        //writer = new BufferedWriter(new FileWriter(file1));
/*        file.seek(0);
        reader = new BufferedReader(new FileReader(file2));
        while ((line = reader.readLine()) != null) {
            file.write(line.getBytes());
        }*/
        //writer.write(fileLine);
        /*file.write(fileLine.getBytes());
        file.close();
        reader.close();*/
        //writer.close();





    }
}
