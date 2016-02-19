package com.javarush.test.level08.lesson08.task02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/* Удалить все числа больше 10
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.
*/

public class Solution
{
    public static void main(String[] args)
    {
        HashSet<Integer> hashSet = createSet();
        printSet(hashSet);
        hashSet = removeAllNumbersMoreThan10(hashSet);
        printSet(hashSet);
    }

    public static void printSet(HashSet<Integer> set)
    {
        System.out.println("Printing Set");
        for (Integer num :
                set)
        {
            System.out.print(num + " ");
        }
    }
    public static HashSet<Integer> createSet()
    {
        //напишите тут ваш код
        HashSet<Integer> hashSet = new HashSet<>();
        while(hashSet.size() != 20)
        {
            hashSet.add(new Random().nextInt(20));
        }
        return hashSet;

    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set)
    {
        //напишите тут ваш код
        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext())
        {
            if (iterator.next() > 10)
                iterator.remove();
        }
        return set;
    }
}
