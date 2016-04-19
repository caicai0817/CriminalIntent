package com.caicai.criminalintent.builder;

/**
 * @Author : caicai
 * @Time : 2016/4/18 11:02
 * @Description: 构造器 工人接口,定义各个工人索要进行的工作,负责进行具体部件如窗户,地板的构建,同事因为房子是民工建的,因此建设完成后由他把房子递交回房主
 */
public interface Builder {
    void makeWindow();
    void makeFloor();
    Room getRoom();
}
