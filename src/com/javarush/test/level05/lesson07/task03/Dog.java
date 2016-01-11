package com.javarush.test.level05.lesson07.task03;

/* Создать класс Dog
Создать класс Dog (собака) с тремя инициализаторами:
- Имя
- Имя, рост
- Имя, рост, цвет
*/

public class Dog
{
    //напишите тут ваш код
    private String name;
    private int hight;
    private String color;

    public void initialize(String name)
    {
        this.name = name;
    }

    public void initialize(String name, int hight)
    {
        this.name = name;
        this.hight = hight;
    }

    public void initialize(String name, int hight, String color)
    {
        this.name = name;
        this.hight = hight;
        this.color = color;
    }
}
