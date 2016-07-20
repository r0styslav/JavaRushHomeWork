package com.javarush.test.level17.lesson10.bonus01;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }


    public static void main(String[] args) throws IOException, ParseException {
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
                    String sex = allPeople.get(index).getSex().equals(Sex.MALE) ? "м" : "ж";
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
