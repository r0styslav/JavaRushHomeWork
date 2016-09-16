package com.javarush.test.practice.System;

import java.util.ArrayList;

/**
 * Created by Rost on 03-Sep-16.
 */
public class TestArrays {

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 0, 0, 0},
                {0, 0, 1, 1},
                {0, 0, 1, 0},
                {1, 1, 1, 1},
                {1, 0, 1, 1},
                {1, 1, 1, 1},
        };

        //Например так:
        //Создаем список для хранения линий
        //Копируем все непустые линии в список.
        //Добавляем недостающие строки в начало списка.
        //Преобразуем список обратно в матрицу
        boolean hasZero, hasOne;
        int height = matrix.length;
        int width = matrix[0].length;
        System.out.println("--------------------------------------------------------------------------");
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        //Например так:
        //Создаем список для хранения линий
        //Копируем все непустые линии в список.
        //Добавляем недостающие строки в начало списка.
        //Преобразуем список обратно в матрицу
        ArrayList<int[]> line = new ArrayList<>();
        int sum;
        for (int i = 0; i < height; i++) {
            sum = 0;
            for (int j = 0; j < width; j++) {
                sum += matrix[i][j];
            }
            if (sum != width && sum != 0) {
                line.add(matrix[i]);
            }
        }

        while (line.size() < height) {
            line.add(0, new int[width]);
        }

        matrix = line.toArray(new int[height][width]);
        System.out.println("--------------------------------------------------------------------------");
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

    }
}
