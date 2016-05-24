package com.javarush.test.level15.lesson12.home05;

/**
 * Created by Rostyslav.Pash on 18-May-16.
 */
public class SubSolution extends Solution{
    public SubSolution() {
    }
    public SubSolution(int a) {
        super(a);
    }

    public SubSolution(String a) {
        super(a);
    }

    protected SubSolution(int a, int b) {
        super(a, b);
    }
    protected SubSolution(String a, String b) {
        super(a, b);
    }
    protected SubSolution(Double a, Double b) {
        super(a, b);
    }

    private SubSolution(short a) {
        super(a);
    }
    private SubSolution(byte a) {
        super(a);
    }
    private SubSolution(double a) {
        super(a);
    }

    SubSolution(Integer a) {
        super(a);
    }
    SubSolution(Solution a) {
        super(a);
    }
    SubSolution(Object a) {
        super(a);
    }
}
