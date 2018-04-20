package com.example.classloader;

/**
 * @author Caicai.
 * @date 2018/4/8.
 * @description
 */

public class SuperClass extends SSClass {
    static {
        System.out.println("superclass");
    }

    public static int value = 123;

    public SuperClass(){
        System.out.println("init superclass");
    }

    public static void rewrite(){
        System.out.println("superclass rewrite");
    }
}
