package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //FileInputStream file = new FileInputStream("r:\\111.txt");
        FileInputStream file = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());

        List<Integer> arrayList = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> repeatedNumbers = new HashMap<>();
        int minCount;

        // read bytes from file
        while (file.available() > 0) {
            arrayList.add(file.read());
        }
        minCount = arrayList.size();
        Set<Integer> uniqueBytes = new HashSet<>(arrayList);

        // find bytes that are less repeated
        for (Integer number :
                uniqueBytes) {
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i) == number) {
                    if (repeatedNumbers.containsKey(number)) {
                        repeatedNumbers.put(number, repeatedNumbers.get(number) + 1);
                    } else {
                        repeatedNumbers.put(number, 1);
                    }
                }
            }
            minCount = repeatedNumbers.get(number) < minCount ? repeatedNumbers.get(number) : minCount;
        }

        // print bytes that less repeat
        for (Map.Entry<Integer, Integer> entry :
                repeatedNumbers.entrySet()) {
            if (entry.getValue() == minCount) {
                //System.out.println(entry.getKey() + " repeated " + entry.getValue());
                System.out.print(entry.getKey() + " ");
            }
        }





    }
}
