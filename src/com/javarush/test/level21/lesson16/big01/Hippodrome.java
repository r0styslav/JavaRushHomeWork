package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by Rost on 20-Aug-16.
 */
public class Hippodrome {
    public static Hippodrome game;
    public ArrayList<Horse> horses = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome();
        Horse h1 = new Horse("horse1", 3, 0);
        Horse h2 = new Horse("horse2", 3, 0);
        Horse h3 = new Horse("horse3", 3, 0);

        game.getHorses().add(h1);
        game.getHorses().add(h2);
        game.getHorses().add(h3);

        game.run();
        game.printWinner();
    }

    public Horse getWinner() {
        double distance = 0;
        Horse horse = null;
        for (Horse h : getHorses()) {
            if (h.getDistance() > distance)
                distance = h.getDistance();
                horse = h;
        }
        return horse;
    }
    public void printWinner() {
        Horse h = getWinner();
        System.out.printf("Winner is %s!\n", h.getName());
    }
    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }
    public void move() {
        for (Horse h : getHorses())
        h.move();
    }
    public void print() {
        for (Horse h : getHorses())
            h.print();
        System.out.println();
        System.out.println();
    }

    public ArrayList<Horse> getHorses() {
        return horses;
    }
}
