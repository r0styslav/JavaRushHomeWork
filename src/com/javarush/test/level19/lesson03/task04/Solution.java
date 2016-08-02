package com.javarush.test.level19.lesson03.task04;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке.
Метод read() должен читать данные одного человека.
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner {
        Scanner sc;

        public PersonScannerAdapter(Scanner sc) {
            this.sc = sc;
        }

        @Override
        public Person read() throws IOException {
            String[] words = sc.nextLine().split(" ");
            Calendar cal = new GregorianCalendar(Integer.parseInt(words[5]), Integer.parseInt(words[4]) - 1, Integer.parseInt(words[3]));
            return new Person(words[1], words[2], words[0], cal.getTime());
        }

        @Override
        public void close() throws IOException {
            sc.close();
        }
    }
}
