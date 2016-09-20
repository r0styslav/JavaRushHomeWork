package com.javarush.test.level21.lesson16.big01;

/**
 * Created by Rost on 20-Aug-16.
 */
public class Horse {
    private double distance, speed;
    private String name;

    public Horse(String name, double speed, double distance) {
        this.distance = distance;
        this.speed = speed;
        this.name = name;
    }

    public void move() {
        distance += speed * Math.random();
    }

    public void print() {
        for (int i = 0; i < (int) distance; i++) {
            System.out.print(".");
        }
        System.out.println(name);
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
