package com.caicai.criminalintent.design.dimite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Caicai.
 * @date 2018/4/23.
 * @description
 */

public class Mediator {
    List<Room> mRooms = new ArrayList<>();
    public Mediator(){
        for (int i = 0; i < 5; i++){
            mRooms.add(new Room(14 + i,(14 + i) * 150));
        }
    }

    public Room rentout(float area,float price){
        for (Room room : mRooms){
            if (isSuitable(area,price,room)){
                return room;
            }
        }

        return null;
    }

    private boolean isSuitable(float area, float price, Room room){
        return Math.abs(room.price - price) < 100 && Math.abs(room.area - area) < 0.0001;
    }
}
