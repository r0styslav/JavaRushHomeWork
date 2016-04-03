package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Human sun1 = new Human("Son1", true, 12);
        Human daughter1 = new Human("daughter2", false, 11);
        Human daughter2 = new Human("daughter2", false, 11);
        Human mother = new Human("Mother", false, 30, sun1, daughter1, daughter2);
        Human father = new Human("father", true, 31, sun1, daughter1, daughter2);
        Human grandFather1 = new Human("grandFather1", true, 61, father);
        Human grandMother1 = new Human("grandMother1", false, 61, father);
        Human grandFather2 = new Human("grandFather2", true, 61, mother);
        Human grandMother2 = new Human("grandMother2", false, 61, mother);

        System.out.println(grandFather1);
        System.out.println(grandMother1);
        System.out.println(grandFather2);
        System.out.println(grandMother2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(daughter1);
        System.out.println(daughter2);
        System.out.println(sun1);

    }

    public static class Human
    {
        //напишите тут ваш код
        private String name;
        private boolean sex;
        private int age;
        private ArrayList<Human> children = new ArrayList<>();

        public Human(String name, boolean man, int age, Human children) {
            this.name = name;
            this.sex = man;
            this.age = age;
            this.children.add(children);
        }

        public Human(String name, boolean man, int age, Human children1, Human children2, Human children3) {
            this.name = name;
            this.sex = man;
            this.age = age;
            this.children.add(children1);
            this.children.add(children2);
            this.children.add(children3);
        }

        public Human(String name, boolean man, int age) {
            this.name = name;
            this.sex = man;
            this.age = age;
        }

        public String toString()
        {
            
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
