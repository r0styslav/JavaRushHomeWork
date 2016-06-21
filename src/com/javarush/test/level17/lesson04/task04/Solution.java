package com.javarush.test.level17.lesson04.task04;

/* Синхронизированный президент
И снова Singleton паттерн - синхронизация в статическом блоке
Внутри класса OurPresident в статическом блоке создайте синхронизированный блок.
Внутри синхронизированного блока инициализируйте president.
*/

public class Solution {
    public static class OurPresident {

        private static OurPresident president;

        private OurPresident() {
        }
        static {
            synchronized (new OurPresident()) {
            }
        }

        public static OurPresident getOurPresident() {
            if(president == null)
                president = new OurPresident();
            return president;
        }
    }

    public static void main(String[] args) {
        OurPresident p1 = OurPresident.getOurPresident();
        OurPresident p2 = OurPresident.getOurPresident();
        System.out.println(p1.equals(p2));
    }
}
