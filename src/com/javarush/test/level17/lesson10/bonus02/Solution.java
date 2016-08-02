package com.javarush.test.level17.lesson10.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id
(index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException, IOException {
        //start here - начни тут
        String line = "";
        //BufferedReader inputLine = new BufferedReader(new InputStreamReader(System.in));
        //while (!(line = inputLine.readLine()).equals("exit")) {
        ArrayList<String> parameters = new ArrayList<>(Arrays.asList(args));
        if (parameters.size() > 0) {
            switch (parameters.get(0)) {
                case "-c":
                    for (int i = 1; i <= parameters.size() - 3; i += 3) {
                        allPeople.add(parameters.get(i + 1).equalsIgnoreCase("м")
                                ? Person.createMale(parameters.get(i), new SimpleDateFormat("dd/MM/yyyy").parse(parameters.get(i + 2)))
                                : Person.createFemale(parameters.get(i), new SimpleDateFormat("dd/MM/yyyy").parse(parameters.get(i + 2))));
                        System.out.println(allPeople.size() - 1);
                    }
                    break;
                case "-u":
                    for (int i = 1; i <= parameters.size() - 4; i += 4) {
                        allPeople.remove(Integer.parseInt(parameters.get(i)));
                        allPeople.add(Integer.parseInt(parameters.get(i)),
                                parameters.get(i + 2).equalsIgnoreCase("м")
                                        ? Person.createMale(parameters.get(i + 1), new SimpleDateFormat("dd/MM/yyyy").parse(parameters.get(i + 3)))
                                        : Person.createFemale(parameters.get(i + 1), new SimpleDateFormat("dd/MM/yyyy").parse(parameters.get(i + 3))));

                    }
                    break;
                case "-d":
                    for (int i = 1; i < parameters.size(); i++) {
                        int indexPerson = Integer.parseInt(parameters.get(i));
                        allPeople.get(indexPerson).setBirthDay(null);
                        allPeople.get(indexPerson).setName(null);
                        allPeople.get(indexPerson).setSex(null);
                    }
                    break;
                case "-i":
                    for (int i = 1; i < parameters.size(); i++) {
                        int index = Integer.parseInt(parameters.get(i));
                        String sex = allPeople.get(index).getSex().equals(Sex.MALE) ? "м" : "ж";
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                        System.out.println(allPeople.get(index).getName()
                                + " " + sex
                                + " " + dateFormat.format(allPeople.get(index).getBirthDay()));
                    }
                    break;
            }
        }
        //}
    }
}
