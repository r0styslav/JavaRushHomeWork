package com.javarush.test.level15.lesson04.task02;

/* ООП - Перегрузка
Перегрузите метод printMatrix 8 различными способами.
В итоге должно получиться 10 различных методов printMatrix.
*/

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
        printMatrix((byte)2, 3, "8");
        printMatrix(2, (byte)3, "8");
        printMatrix((float)2, 3, "8");
        printMatrix(2, (float)3, "8");
        printMatrix(2,  "8", 3);
        printMatrix( "8", 2, 3);
        printMatrix(2, 3, 8);
        printMatrix(2, 3, "8");
        printMatrix("8");
    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("1");
        printMatrix(m, n, (Object) value);
    }
    public static void printMatrix(byte m, int n, String value) {
        System.out.println("2");
    }
    public static void printMatrix(int m, byte n, String value) {
        System.out.println("3");

    }
    public static void printMatrix(float m, int n, String value) {
        System.out.println("4");

    }
    public static void printMatrix(int m, float n, String value) {
        System.out.println("5");
    }
    public static void printMatrix(int m, String value, int n ) {
        System.out.println("6");
    }
    public static void printMatrix(String value, int m, int n) {
        System.out.println("7");
        printMatrix(m, n, (Object) value);
    }
    public static void printMatrix(int m, int n, int value) {
        System.out.println("8");
        printMatrix(m, n, (Object) value);
    }
    public static void printMatrix(String value) {
        System.out.println("9");
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }
}
