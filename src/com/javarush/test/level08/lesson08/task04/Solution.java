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
/*    public static HashMap<String, Date> mapa;
    public static void main(String[] args)
    {
        mapa = createMap();
        printMap(mapa);
        removeAllSummerPeople(mapa);
        printMap(mapa);
    }*/
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("qwe", new Date("JULY 31 1985"));
        map.put("asd", new Date("APRIL 1 1980"));
        map.put("zxc", new Date("APRIL 1 1980"));
        map.put("sdf", new Date("DECEMBER 1 1980"));
        map.put("wer", new Date("JUNE 1 1980"));
        map.put("dfg", new Date("SEPTEMBER 1 1980"));
        map.put("cvb", new Date("JANUARY 1 1980"));
        map.put("fgh", new Date("AUGUST 1 1980"));
        map.put("rty", new Date("OCTOBER 1 1980"));

        //напишите тут ваш код
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        //напишите тут ваш код
        Iterator<Map.Entry<String, Date>> iter = map.entrySet().iterator();
        Map.Entry<String, Date> mapInstance;
        while (iter.hasNext())
        {
            mapInstance = iter.next();
            if (mapInstance.getValue().getMonth() == 5 ||
                    mapInstance.getValue().getMonth() == 6 ||
                    mapInstance.getValue().getMonth() == 7)
                iter.remove();

        }
    }
/*
    public static void printMap(HashMap<String, Date> map)
    {
        System.out.println("======================================================");
        for (Map.Entry<String, Date> instance :
                map.entrySet())
        {
            System.out.println(instance.getKey() + " " + instance.getValue());
        }
    }*/

}
