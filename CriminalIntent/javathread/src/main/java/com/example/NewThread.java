package com.example;

/**
 * @author Caicai.
 * @date 2018/3/21.
 * @description
 */

public class NewThread extends Thread {
    public volatile boolean exit = false;

    @Override
    public void run(){
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
