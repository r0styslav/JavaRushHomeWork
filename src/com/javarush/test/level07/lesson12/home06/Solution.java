package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human).
Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей.
Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться
при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Human gFather = new Human("Granny", true, 60);
        Human gFather2 = new Human("Granny2", true, 61);
        Human gMother = new Human("gMother", false, 50);
        Human gMother2 = new Human("gMother2", false, 51);

        Human father = new Human("Father", true, 31, gFather, gMother);
        Human mother = new Human("Mother", false, 29, gFather2, gMother2);

        Human son = new Human("Son", true, 18, father, mother);
        Human dauther = new Human("Dauther", false, 16, father, mother);
        Human son2 = new Human("SOn2", true, 12, father, mother);

        System.out.println(gFather);
        System.out.println(gFather2);
        System.out.println(gMother);
        System.out.println(gMother2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(son);
        System.out.println(dauther);
        System.out.println(son2);
    }

    public static class Human
    {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        Human father, mother;

        public Human(String name, boolean sex, int age)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            father = null;
            mother = null;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
