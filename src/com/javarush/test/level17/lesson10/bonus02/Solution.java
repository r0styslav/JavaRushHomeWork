package com.javarush.test.level17.lesson10.bonus02;

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
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
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

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        String inputLine = "";
        //while (!inputLine.equals("exit")) {
        List<String> parameters = new ArrayList<>(Arrays.asList(args));
        if (parameters.size() > 0) {
            switch (parameters.get(0)) {
                case "-c":
                    allPeople.add(parameters.get(2).equalsIgnoreCase("м")
                            ? Person.createMale(parameters.get(1), new SimpleDateFormat("dd/MM/yyyy").parse(parameters.get(3)))
                            : Person.createFemale(parameters.get(1), new SimpleDateFormat("dd/MM/yyyy").parse(parameters.get(3))));
                    System.out.println(allPeople.size() - 1);
                    System.out.println(allPeople.size() - 1);
                    break;
                case "-u":
                    allPeople.remove(Integer.parseInt(parameters.get(1)));
                    allPeople.add(Integer.parseInt(parameters.get(1)),
                            parameters.get(3).equalsIgnoreCase("м")
                                    ? Person.createMale(parameters.get(2), new SimpleDateFormat("dd/MM/yyyy").parse(parameters.get(4)))
                                    : Person.createFemale(parameters.get(2), new SimpleDateFormat("dd/MM/yyyy").parse(parameters.get(4))));
                    break;
                case "-d":
                    //allPeople.remove(Integer.parseInt(parameters.get(1)));
                    int indexPerson = Integer.parseInt(parameters.get(1));
                    allPeople.get(indexPerson).setBirthDay(null);
                    allPeople.get(indexPerson).setName(null);
                    allPeople.get(indexPerson).setSex(null);
                    break;
                case "-i":
                    int index = Integer.parseInt(parameters.get(1));
                    String sex = allPeople.get(index).getSex().equals(com.javarush.test.level17.lesson10.bonus01.Sex.MALE) ? "м" : "ж";
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                    System.out.println(allPeople.get(index).getName()
                            + " " + sex
                            + " " + dateFormat.format(allPeople.get(index).getBirthDay()));
                    /*System.out.println(allPeople.get(index).getName() + " "
                            + allPeople.get(index).getSex() + " "
                            + new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(allPeople.get(index).getBirthDay()));*/

                    break;
            }
        }
        //}
    }
}

