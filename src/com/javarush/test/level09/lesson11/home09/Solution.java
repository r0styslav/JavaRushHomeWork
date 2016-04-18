package com.javarush.test.level09.lesson11.home09;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap()
    {
        //напишите тут ваш код
        Map<String, Cat> cat = new HashMap<>();
        cat.put("Vasya", new Cat("Vas"));
        cat.put("Ivan", new Cat("Iv"));
        cat.put("Petro", new Cat("PEtr"));
        cat.put("Orest", new Cat("Or"));
        cat.put("Vita", new Cat("Vi"));
        cat.put("John", new Cat("J"));
        cat.put("New", new Cat("Ne"));
        cat.put("Noob", new Cat("No"));
        cat.put("QWE", new Cat("Q"));
        cat.put("Asd", new Cat("A"));
        return cat;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map)
    {
        //напишите тут ваш код
        return new HashSet<>(map.values());
    }

    public static void printCatSet(Set<Cat> set)
    {
        for (Cat cat:set)
        {
            System.out.println(cat);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat "+this.name;
        }
    }


}
