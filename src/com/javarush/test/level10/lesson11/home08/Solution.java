package com.javarush.test.level10.lesson11.home08;


import java.util.ArrayList;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести их на экран.
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        //напишите тут ваш код

        ArrayList<String>[] arrayStrings = new ArrayList[4];
        //String[] abc = new String[5];
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<String> list3 = new ArrayList<>();
        ArrayList<String> list4 = new ArrayList<>();

        arrayStrings[0] = new ArrayList<>();
        arrayStrings[1] = new ArrayList<>();
        arrayStrings[2] = new ArrayList<>();
        arrayStrings[3] = new ArrayList<>();
        for (int j = 0; j < 5; j++) {
            list.add("String " + j);
        }
        for (int j = 0; j < 5; j++) {
            list2.add("String " + j);
        }
        for (int j = 0; j < 5; j++) {
            list3.add("String " + j);
        }
        for (int j = 0; j < 5; j++) {
            list4.add("String " + j);
        }


        arrayStrings[0] = list;
        arrayStrings[1] = list2;
        arrayStrings[2] = list3;
        arrayStrings[3] = list4;
        return arrayStrings;

    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}