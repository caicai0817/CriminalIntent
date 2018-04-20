package com.example.classloader;

/**
 * @author Caicai.
 * @date 2018/4/8.
 * @description
 */

public class SSClass {
    static {
        System.out.println("ssclass");
    }

    public static void rewrite(){
        System.out.println("ssclass rewrite");
    }
}
