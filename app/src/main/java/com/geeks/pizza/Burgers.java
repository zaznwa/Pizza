package com.geeks.pizza;

public class Burgers {
    private String burgerName;
    private int burgerImg;

    @Override
    public String toString() {
        return "Burgers{" +
                "burgerName='" + burgerName + '\'' +
                ", burgerImg=" + burgerImg +
                '}';
    }

    public Burgers(String burgerName, int burgerImg) {
        this.burgerName = burgerName;
        this.burgerImg = burgerImg;
    }

    public String getBurgerName() {
        return burgerName;
    }

    public int getBurgerImg() {
        return burgerImg;
    }
}
