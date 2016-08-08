package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        //BufferedReader reader = new BufferedReader(new FileReader("r:\\1\\1.txt"));
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        Map<String, Double> map = new HashMap<>();

        while (reader.ready()) {
            String[] line = reader.readLine().split(" ");
            if (map.containsKey(line[0]))
                map.put(line[0], map.get(line[0]) + Double.parseDouble(line[1]));
            else
                map.put(line[0], Double.parseDouble(line[1]));
        }
        String value = "";
        double max = 0;
        for (Map.Entry<String, Double> m: map.entrySet()) {
            if (m.getValue() > max) {
                max = m.getValue();
                value = m.getKey();
            }
        }

        System.out.println(value);

        reader.close();
    }
}
