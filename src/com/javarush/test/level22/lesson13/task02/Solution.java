package com.javarush.test.level22.lesson13.task02;

import java.io.*;
import java.nio.charset.Charset;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        Charset utf8 = Charset.forName("UTF-8");
        Charset windows1251 = Charset.forName("Windows-1251");
        InputStream inputStreamReader = new FileInputStream("c:/1.txt");
        //FileInputStream inputStreamReader = new FileInputStream(args[0]);
        OutputStream outputStream = new FileOutputStream("C:/2.txt");
        //FileOutputStream outputStream = new FileOutputStream(args[1]);
        byte arr[] = new byte[inputStreamReader.available()];
        inputStreamReader.read(arr);
        String s = new String(arr, utf8);
        arr = s.getBytes(windows1251);
        outputStream.write(arr);

        inputStreamReader.close();
        outputStream.close();

    }
}
