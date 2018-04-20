package com.example;

import java.util.ArrayList;

/**
 * @author Caicai.
 * @date 2018/3/26.
 * @description
 */

public class Animal {
    public String name = "animal";
    public int age = 1;
    public ArrayList<String> food = new ArrayList<>();

    public Animal(){
    }

    public Animal(String name, int age, ArrayList<String> food){
        this.name = name;
        this.age = age;
        this.food = food;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<String> getFood() {
        return food;
    }

    public void setFood(ArrayList<String> food) {
        this.food = food;
    }
}
