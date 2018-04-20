package com.example;

/**
 * @author Caicai.
 * @date 2018/3/22.
 * @description
 */

public class Thread1 extends Thread {
    public Thread1(){
        super("Thread1");
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + "start");

        try{
            for (int i = 0;i < 5; i++){
                System.out.println(threadName + "--loop at--" + i);
                Thread.sleep(1000);
            }
            System.out.println(threadName + "end");
        }catch(Exception e){

        }

    }
}
