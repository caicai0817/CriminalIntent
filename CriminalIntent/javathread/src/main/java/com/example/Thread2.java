package com.example;

/**
 * @author Caicai.
 * @date 2018/3/22.
 * @description
 */

public class Thread2 extends Thread {
    Thread1 thread1;

    public Thread2(Thread1 thread1){
        super("Thread2");
        this.thread1 = thread1;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + "start");

        try{
            thread1.join();
            for (int i = 0; i < 3;i++){
                System.out.println(threadName + "~~loop at~~" + i);
                Thread.sleep(1000);
            }
            System.out.println(threadName + "end");
        }catch(Exception e){

        }
    }
}
