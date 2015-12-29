package com.javarush.test.level02.lesson05.task03;

import java.security.acl.Owner;

/* У каждого животного должна быть хозяйка.
Создайте объект типа Cat(кот), объект типа Dog (собака), объект типа Fish (рыбка) и объект типа Woman.
Присвойте каждому животному владельца (owner).
*/
public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Woman woman = new Woman();
        Cat cat = new Cat();
        Dog dog = new Dog();
        Fish fish= new Fish();
        cat.owner = woman;
        dog.owner = woman;
        fish.owner = woman;

    }

    public static class Cat
    {
        public Woman owner;
    }

    public static class Dog
    {
        public Woman owner;
    }

    public static class Fish
    {
        public Woman owner;
    }

    public static class Woman
    {
    }
}
