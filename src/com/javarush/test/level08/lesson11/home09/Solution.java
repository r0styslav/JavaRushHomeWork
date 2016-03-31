package com.javarush.test.level08.lesson11.home09;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args) throws ParseException {
        System.out.println(isDateOdd("JANUARY 1 2000"));
        System.out.println(isDateOdd("JANUARY 2 2016"));
        System.out.println(isDateOdd("JUNE 16 2016"));
    }

    public static boolean isDateOdd(String date) throws ParseException {
        int dayNumber;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM d yyyy");
        Date formatDate = simpleDateFormat.parse(date);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(formatDate);
        dayNumber = calendar.get(Calendar.DAY_OF_YEAR);
        System.out.println(dayNumber);
        return dayNumber % 2 == 1;
    }
}
