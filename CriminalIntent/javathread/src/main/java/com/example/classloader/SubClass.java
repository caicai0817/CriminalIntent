package com.example.classloader;

/**
 * @author Caicai.
 * @date 2018/4/8.
 * @description
 */

public class SubClass extends SuperClass {
    static {
        System.out.println("subclass");
    }

    static int a;

    public SubClass(){
        System.out.println("init subclass");
    }
}
