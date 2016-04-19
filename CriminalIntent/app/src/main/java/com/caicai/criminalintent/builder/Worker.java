package com.caicai.criminalintent.builder;

/**
 * @Author : caicai
 * @Time : 2016/4/18 11:10
 * @Description: 具体构造者工人,负责进行具体部件如窗户,地板的建造
 */
public class Worker implements Builder{

    private Room room = new Room();
    @Override
    public void makeWindow() {
        room.window = new String("双开门");
    }

    @Override
    public void makeFloor() {
        room.floor = new String("马可波罗");
    }

    @Override
    public Room getRoom() {
        return room;
    }
}
