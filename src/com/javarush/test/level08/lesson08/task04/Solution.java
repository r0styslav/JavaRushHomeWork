package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static void main(String[] args)
    {
        HashMap<String, Date> map = createMap();
        removeAllSummerPeople(map);
        System.out.println(map);
    }
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("S", new Date("JUNE 1 1980"));
        map.put("St", new Date("JULY 1 1980"));
        map.put("Sta", new Date("APRIL 1 1980"));
        map.put("Stal", new Date("OCTOBER 1 1980"));
        map.put("Stall", new Date("JANUARY 1 1980"));
        map.put("Stallo", new Date("FEBRUARY 1 1980"));
        map.put("Stallon", new Date("MARCH 1 1980"));
        map.put("Stallonee", new Date("APRIL 1 1980"));
        map.put("Stalloneee", new Date("MAY 1 1980"));
        map.put("Stalloneeee", new Date("AUGUST 1 1980"));

        //напишите тут ваш код
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        //напишите тут ваш код
        Map.Entry<String, Date> newMap;
        Iterator<Map.Entry<String, Date>> iter = map.entrySet().iterator();
        while (iter.hasNext())
        {
            newMap = iter.next();
            Date date = newMap.getValue();
            if (date.getMonth() == 5 || date.getMonth() == 6 || date.getMonth() == 7)
                map.remove(newMap.getKey());
        }
    }
}
