package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[1]);
        FileOutputStream outputStream = new FileOutputStream(args[2]);

        switch (args[0]) {
            case "-e":
                while (inputStream.available() > 0) {
                    int data = inputStream.read();
                    outputStream.write(data + 5);
                }
                break;
            case "-d":
                while (inputStream.available() > 0) {
                    int data = inputStream.read();
                    outputStream.write(data - 5);
                }
        }

        inputStream.close();
        outputStream.close();

    }

}
