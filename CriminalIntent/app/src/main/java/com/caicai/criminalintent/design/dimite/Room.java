package com.caicai.criminalintent.design.dimite;

/**
 * @author Caicai.
 * @date 2018/4/23.
 * @description 迪米特原则
 */

public class Room {
    public float area;
    public float price;

    public Room(float area, float price) {
        this.area = area;
        this.price = price;
    }

    @Override
    public String toString() {
        return "area = " + this.area + "--price = " + this.price;
    }
}
