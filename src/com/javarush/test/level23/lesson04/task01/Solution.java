package com.javarush.test.level23.lesson04.task01;

/* Inner
Реализовать метод getTwoSolutions, который должен возвращать массив из 2-х экземпляров класса Solution.
Для каждого экземпляра класса Solution инициализировать поле innerClasses двумя значениями.
Инициализация всех данных должна происходить только в методе getTwoSolutions.
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }
    //  InnerClass inner1 = new OuterClass().new InnerClass();
    //  OuterClass ouetClass = new OuterClass();
    //  OuterClass.InnerClass inner = ouetClass.new InnerClass();
    public static Solution[] getTwoSolutions() {
        Solution[] solutions = new Solution[2];
        Solution solution1 = new Solution();
        Solution solution2 = new Solution();
        solution1.innerClasses[0] = solution1.new InnerClass();
        solution1.innerClasses[1] = solution1.new InnerClass();
        solution2.innerClasses[0] = solution2.new InnerClass();
        solution2.innerClasses[1] = solution2.new InnerClass();
        solutions[0] = solution1;
        solutions[1] = solution2;
        return solutions;
    }
}
