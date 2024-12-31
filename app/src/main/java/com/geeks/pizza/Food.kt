package com.geeks.pizza;

import android.widget.ImageView;

public class Food {
    private String foodName;
    private int foodImg;

    @Override
    public String toString() {
        return "Food{" +
                "foodName='" + foodName + '\'' +
                ", foodImg=" + foodImg +
                '}';
    }

    public Food(String foodName, int foodImg) {
        this.foodName = foodName;
        this.foodImg = foodImg;
    }

    public int getFoodImg() {
        return foodImg;
    }

    public String getFoodName() {
        return foodName;
    }
}
