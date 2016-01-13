package com.javarush.test.level05.lesson12.home03;

/* Создай классы Dog, Cat, Mouse
Создай классы Dog, Cat, Mouse. Добавь по три поля в каждый класс, на твой выбор. Создай объекты для героев мультика Том и Джерри.
Так много, как только вспомнишь.
Пример:
Mouse jerryMouse = new Mouse(“Jerry”, 12 , 5), где 12 - высота в см, 5 - длина хвоста в см.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Mouse jerryMouse = new Mouse("Jerry1", 122 , 25);

        //напишите тут ваш код
        Mouse jerryMouse1 = new Mouse("Jerry", 12 , 5);
        Cat tom = new Cat("Tom", 15 , 15);
        Cat cat1 = new Cat("Cat", 12 , 25);
        Cat catTom = new Cat("Tom1", 22 , 55);
        Dog dog = new Dog("Dog", 3 ,2);
        Dog aDog = new Dog("doggy", 13 , 6);
        Dog bigDog = new Dog("BigDog", 52 , 1);
    }

    public static class Mouse
    {
        String name;
        int height;
        int tail;

        public Mouse(String name, int height, int tail)
        {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }
    }

    //добавьте тут ваши классы
    public static class Dog
    {
        String name;
        int height;
        int weight;

        public Dog(String name, int height, int weight)
        {
            this.name = name;
            this.height = height;
            this.weight = weight;
        }
    }
    public static class Cat
    {
        String name;
        int height;
        int weight;

        public Cat(String name, int height, int weight)
        {
            this.name = name;
            this.height = height;
            this.weight = weight;
        }
    }

}
