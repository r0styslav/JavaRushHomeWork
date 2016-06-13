package com.javarush.test.level16.lesson13.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

/* Клубок
1. Создай 5 различных своих нитей c отличным от Thread типом:
1.1. нить 1 должна бесконечно выполняться;
1.2. нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
1.3. нить 3 должна каждые полсекунды выводить "Ура";
1.4. нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. нить 5 должна читать с консоли цифры пока не введено слово "N", а потом вывести в консоль сумму введенных цифр.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.
Подсказка: Нить 4 можно проверить методом isAlive()
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<Thread>(5);

    static {
        threads.add(new Thread1());
    }
    static class Thread5 extends Thread{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        int sum = 0;
        @Override
        public void run() {
            try {
                while ((str = br.readLine()) != "N") {
                    int i = Integer.parseInt(str);
                    sum += i;
                }
                System.out.println(sum);
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class Thread4 extends Thread implements Message{

        @Override
        public void run() {
            if (isInterrupted()) {
                this.interrupt();
            }
        }

        @Override
        public void showWarning() {
            this.interrupt();
        }
    }

    static class Thread3 extends Thread {

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("Ура");

                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Thread2 extends Thread {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException");
                }
            }
        }
    }

    static class Thread1 extends Thread {

        @Override
        public void run() {
            while (true) {

            }
        }
    }


}
