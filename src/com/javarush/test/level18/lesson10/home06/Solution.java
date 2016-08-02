package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        Map<Integer, Integer> charMap = new TreeMap<>();
        FileInputStream inputStream = new FileInputStream(args[0]);

        while (inputStream.available() > 0) {
            int currentSymbol = inputStream.read();
            if (charMap.containsKey(currentSymbol)) {
                charMap.put(currentSymbol, charMap.get(currentSymbol) + 1);
            } else {
                charMap.put(currentSymbol, 1);
            }
        }

        for (Map.Entry<Integer, Integer> map:
             charMap.entrySet()) {

            System.out.println((char)(int)(map.getKey()) + " " + map.getValue());
        }

        inputStream.close();
    }
}
