package com.example;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Caicai.
 * @date 2018/3/20.
 * @description
 */

public class NewClass implements Serializable{
    private String mName;
    public int mAge;
    public ArrayList<String> list = new ArrayList<>();

    public ArrayList<String> getList() {
        return this.list;
    }

    public void setList(String value) {
        this.list.add(value);
    }
    public String getmName() {
        return mName;
    }

    private void setmName(String mName) {
        this.mName = mName;
    }

    public int getmAge() {
        return mAge;
    }

    public void setmAge(int mAge) {
        this.mAge = mAge;
    }

    public NewClass(){

    }

    public  NewClass(String mName, int mAge) {
        this.mName = mName;
        this.mAge = mAge;
    }

}
