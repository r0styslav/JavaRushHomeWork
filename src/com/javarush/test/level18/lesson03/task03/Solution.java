package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        FileInputStream file = new FileInputStream(filename);
        //FileInputStream file = new FileInputStream("r:\\111.txt");

        List<Integer> arrayList = new ArrayList<>();
        Map<Integer, Integer> repeatCount = new HashMap<>();
        int maxCount = 0;
        while (file.available() > 0) {
            arrayList.add(file.read());
        }

        Set<Integer> setArray = new HashSet<>();
        Set<Integer> uniqueSetArray = new HashSet<>();

       /* for (Integer num :
                arrayList) {
            System.out.print(num + " ");
        }*/

        for (Integer num :
                arrayList) {
            if (!setArray.add(num)) {
                uniqueSetArray.add(num);
                //System.out.print(num + " ");
            }
        }
        System.out.println();

        for (Integer number :
                uniqueSetArray) {
            for (int j = 0; j < arrayList.size(); j++) {
                if (arrayList.get(j) == number) {
                    if (repeatCount.containsKey(number)) {
                        repeatCount.put(number, repeatCount.get(number) + 1);
                    } else {
                        repeatCount.put(number, 1);
                    }
                }

            }
            maxCount = repeatCount.get(number) > maxCount ? repeatCount.get(number) : maxCount;
        }
        System.out.println();

        for (Map.Entry<Integer, Integer> entry:
                repeatCount.entrySet()) {
            if (entry.getValue() == maxCount) {
                //System.out.println(entry.getKey() + " repeated " + entry.getValue());
                System.out.print(entry.getKey() + " ");
            }
        }
        reader.close();
        file.close();
    }
}
