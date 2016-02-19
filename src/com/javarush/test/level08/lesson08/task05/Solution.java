package com.javarush.test.level08.lesson08.task05;

import java.util.HashMap;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static void main(String[] args)
    {
        HashMap<String, String> hashMap = createMap();
        System.out.println(hashMap);
        removeItemFromMapByValue(hashMap, "Ivan");
        System.out.println(hashMap);

        hashMap = createMap();
        System.out.println(hashMap);
        removeTheFirstNameDuplicates(hashMap);
        System.out.println(hashMap);
    }
    public static HashMap<String, String> createMap()
    {
        //напишите тут ваш код
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("1", "Ivan");
        hashMap.put("2", "Igor");
        hashMap.put("3", "Egor");
        hashMap.put("4", "Ira");
        hashMap.put("5", "Ivan");
        hashMap.put("6", "Ivan");
        hashMap.put("7", "Ivan");
        hashMap.put("8", "Ivan");
        hashMap.put("9", "Inka");
        hashMap.put("10", "Ivanna");
        return hashMap;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        //напишите тут ваш код
        HashMap<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair :
                copy.entrySet())
        {
            removeItemFromMapByValue(map, pair.getValue());
        }

    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        String name = "";
        int copies = 0;
        HashMap<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value) && copies == 0)
            {
                name = pair.getKey();
                copies++;
            } else if (pair.getValue().equals(value) && copies > 0)
            {
                map.remove(name);
                map.remove(pair.getKey());
            }
        }
    }
}
