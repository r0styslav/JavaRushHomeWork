package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла,
генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;

public class Solution {
    private static int maxId;
    private static int id;
    private static String prodName;
    private static String price;
    private static String quantity;
    private static String[] parameters;

    public static void main(String[] args) throws Exception {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = inputReader.readLine();
        //String fileName = "r:\\1\\1.txt";
        // to be commented
        /*args = new String[]{"-c",
                "Sorti plajnie sernie Sorti plajnie sernie Sorti plajnie sernie",
                "15689.7758164",
                "15151515"};*/
        parameters = args;
        getMaxId(fileName);
        prepareId();
        prepareProdName();
        preparePrice();
        prepareQuantity();
        writeLine(fileName);
    }

    private static void writeLine(String fileName) throws IOException {
        BufferedWriter outWriter = new BufferedWriter(new FileWriter(fileName, true));
        outWriter.write(Integer.toString(id) + prodName + price + quantity);
        outWriter.close();
    }

    private static void prepareQuantity() {
        quantity = parameters[3];
        if (quantity.length() <= 4) {
            while (quantity.length() < 4) {
                quantity += " ";
            }
        } else {
            quantity = quantity.substring(0, 4);
        }
    }

    private static void preparePrice() {
        price = parameters[2];
        if (price.length() <= 8) {
            while (price.length() < 8) {
                price += " ";
            }
        } else {
            price = price.substring(0, 8);
        }
    }

    private static void prepareProdName() {
        prodName = parameters[1];
        if (prodName.length() <= 30) {
            while (prodName.length() < 30) {
                prodName += " ";
            }
        } else {
            prodName = prodName.substring(0, 30);
        }
    }

    private static void prepareId() {
        // prepare id
        id = maxId + 1;
    }

    private static void getMaxId(String file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = "";
        maxId = 0;
        while ((line = reader.readLine()) != null) {
            Integer id = Integer.parseInt(line.substring(0, 8).replaceAll(" ",""));
            maxId = maxId < id ? id : maxId;
        }
        reader.close();
    }


}
