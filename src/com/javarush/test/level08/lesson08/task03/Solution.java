package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static void main(String[] args)
    {
        HashMap<String, String> names = createMap();
        System.out.println(getCountTheSameFirstName(names, "Carl"));
        System.out.println(getCountTheSameLastName(names, "I2tyna"));
    }
    public static HashMap<String, String> createMap()
    {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<>();
        map.put("I2tyna", "Carl");
        map.put("ICantyn", "Carl");
        map.put("Isatnt1", "Carq");
        map.put("sIasdfnth", "Carw");
        map.put("Iddfsa", "Carg");
        map.put("Iasdfa", "Carlh");
        map.put("Ialsfda", "Carlgs");
        map.put("sIa", "Carlsdf");
        map.put("Isagf", "Carl");
        map.put("Iafff", "Carlsdf");
        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        //напишите тут ваш код
        int count = 0;
        for (Map.Entry<String, String> hashMap :
                map.entrySet())
        {
            if (hashMap.getValue().equalsIgnoreCase(name) )
                count++;
        }
        return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName)
    {
        //напишите тут ваш код
        int count = 0;
        for (Map.Entry<String, String> hashMap :
                map.entrySet())
        {
            if (hashMap.getKey().equalsIgnoreCase(lastName) )
                count++;
        }
        return count;
    }
}
