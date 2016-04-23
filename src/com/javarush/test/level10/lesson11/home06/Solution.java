package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        //напишите тут ваши переменные и конструкторы
        private String name;
        private String secondName;
        private int age;
        private String mother;
        private String father;
        private String job;

        public Human(String name, String secondName) {
            this.name = name;
            this.secondName = secondName;
        }

        public Human(String name, String secondName, int age, String mother, String father) {
            this.name = name;
            this.secondName = secondName;
            this.age = age;
            this.mother = mother;
            this.father = father;
        }

        public Human(String name, String secondName, int age) {
            this.name = name;
            this.secondName = secondName;
            this.age = age;
        }

        public Human(String name, String secondName, int age, String mother, String father, String job) {
            this.name = name;
            this.secondName = secondName;
            this.age = age;
            this.mother = mother;
            this.father = father;
            this.job = job;
        }

        public Human(String name, String secondName, String job) {
            this.name = name;
            this.secondName = secondName;
            this.job = job;
        }

        public Human(String name, String secondName, int age, String mother) {
            this.name = name;
            this.secondName = secondName;
            this.age = age;
            this.mother = mother;
        }

        public Human(String secondName, int age) {
            this.secondName = secondName;
            this.age = age;
        }

        public Human(int age, String mother, String father) {
            this.age = age;
            this.mother = mother;
            this.father = father;
        }

        public Human() {
        }

        public Human(String job) {
            this.job = job;
        }
    }
}
