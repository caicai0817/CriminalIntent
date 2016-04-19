package com.caicai.criminalintent.builder;

/**
 * @Author : caicai
 * @Time : 2016/4/18 11:07
 * @Description: 指导者,他知道贩子应该怎么设计,但是他不会自己去构建,而是指挥工人建造
 */
public class Designer {

    /**
     * 指挥民工工作
     * @param builder
     */
    public void order(Builder builder){
        builder.makeWindow();
        builder.makeFloor();
    }
}
