package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        Calendar birthdayCalendar = new GregorianCalendar();
        while (reader.ready()) {
            String[] words = reader.readLine().split(" ");
            String name = words[0];

            for (int i = 1; i < words.length - 3; i++) {
                name += " " + words[i];
            }
            birthdayCalendar.set(Integer.parseInt(words[words.length - 1]),
                    Integer.parseInt(words[words.length - 2]) - 1,
                    Integer.parseInt(words[words.length - 3]));

            PEOPLE.add(new Person(name, birthdayCalendar.getTime()));
        }

        reader.close();
    }

}
