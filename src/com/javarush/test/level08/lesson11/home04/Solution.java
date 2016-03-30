package com.javarush.test.level08.lesson11.home04;

import java.io.BufferedReader;
import java.io.IOException ;
import java.io.InputStreamReader;
import java.nio.charset.CodingErrorAction;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* Минимальное из N чисел
1. Ввести с клавиатуры число N.
2. Считать N целых чисел и заполнить ими список - метод getIntegerList.
3. Найти минимальное число среди элементов списка - метод getMinimum.
*/

public class Solution
{
    public static void main(String[] args) throws Exception {
        List<Integer> integerList = getIntegerList();
        System.out.println(getMinimum(integerList));
    }  

    public static int getMinimum(List<Integer> array) {
        // Найти минимум
        int minValue = array.get(0);
            for (Integer integer :
                    array) {
                if (integer < minValue)
                    minValue = integer;
            }
        return minValue;
    }

    public static List<Integer> getIntegerList() throws IOException {
        //Тут создать и заполнить список
        List<Integer> integerList = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < number; i++) {
            integerList.add(Integer.parseInt(bufferedReader.readLine()));
        }
        return integerList;
    }
}
