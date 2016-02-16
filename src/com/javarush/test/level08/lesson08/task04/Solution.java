package com.javarush.test.level08.lesson08.task04;

import java.util.*;

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
        Iterator<Map.Entry<String, Date>> iter = map.entrySet().iterator();
        while (iter.hasNext())
        {
            //Date date = newMap.getValue();
            Calendar date = Calendar.getInstance();
            date.setTime(iter.next().getValue());
            if (date.get(Calendar.MONTH) == Calendar.JUNE
                    || date.get(Calendar.MONTH) == Calendar.JULY
                    || date.get(Calendar.MONTH) == Calendar.AUGUST)
                iter.remove();
        }
    }
}
