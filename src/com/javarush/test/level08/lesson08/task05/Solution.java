package com.javarush.test.level08.lesson08.task05;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него
десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static void main(String[] args)
    {
        HashMap<String, String> map = createMap();
        removeTheFirstNameDuplicates(map);
        System.out.println(map);
    }
    public static HashMap<String, String> createMap()
    {
        //напишите тут ваш код
        HashMap<String, String> vocabulary = new HashMap<>();
        vocabulary.put("Gogo", "Carl");
        vocabulary.put("SOso", "Ivan");
        vocabulary.put("Momo", "Petr");
        vocabulary.put("Koko", "carl");
        vocabulary.put("Bobo", "John");
        vocabulary.put("Roro", "Tolik");
        vocabulary.put("ToTo", "Jay");
        vocabulary.put("Hoho", "Zero");
        vocabulary.put("Popo", "Mukola");
        vocabulary.put("Lolo", "Ivan");
        return vocabulary;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        //напишите тут ваш код
        Iterator<Map.Entry<String,String>> iterator = map.entrySet().iterator();
        Iterator<Map.Entry<String,String>> iteratorNext = map.entrySet().iterator();



    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
