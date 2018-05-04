package com.example;
import com.example.FinalizeEscapeGC;
import com.example.classloader.SSClass;
import com.example.classloader.SubClass;
import com.example.strategy.Horse;
import com.example.strategy.StrategyA;

import java.util.ArrayList;

import sun.rmi.runtime.Log;


public class MyClass {
    static int x = 0, y = 0;
    static int a = 0, b = 0;

    public static void main(String[] args) throws Exception {
        Thread one = new Thread(new Runnable() {
            @Override
            public void run() {
                a = 1;
                x = b;
            }
        });

        Thread other = new Thread(new Runnable() {
            @Override
            public void run() {
                b = 1;
                y = a;
            }
        });

        one.start();
        other.start();
        one.join();
        other.join();
        System.out.println("x = " + x + ",y = " + y);


//        int i = 0;
//        for (; i<=5; i++){
//            System.out.println(i);
//        }
//
//        System.out.println("end" + i);
//        System.out.println(SubClass.value);

//        SSClass.rewrite();
//        SubClass.rewrite();

//        Horse horese = new Horse();
//        horese.factory("lose");
//        horese.horseInterface();



//        System.out.println(Math.round(-1.6));




        //垃圾回收
//        FinalizeEscapeGC.SAVE_HOOK = new FinalizeEscapeGC();
//
//        FinalizeEscapeGC.SAVE_HOOK = null;
//        System.gc();
//        Thread.sleep(500);
//        if (FinalizeEscapeGC.SAVE_HOOK != null){
//            FinalizeEscapeGC.SAVE_HOOK.isAlive();
//        }else {
//            System.out.println("no, i am dead");
//        }
//
//        FinalizeEscapeGC.SAVE_HOOK = null;
//        System.gc();
//        Thread.sleep(500);
//        if (FinalizeEscapeGC.SAVE_HOOK != null){
//            FinalizeEscapeGC.SAVE_HOOK.isAlive();
//        }else {
//            System.out.println("no, i am dead");
//        }










//        String str1 = new StringBuilder("计算机").append("软件").toString();
//        System.out.println(str1.intern() == str1);
//
//        String str2 = new StringBuilder("ja").append("va").toString();
//        System.out.println(str2.intern() == str2);




//        String s = new String("1");
//        s.intern();
//        String s2 = "1";
//        System.out.println(s == s2);
//
//        String s3 = new String("1") + new String("1");
//        s3.intern();
//        String s4 = "11";
////        s3.intern();
//        System.out.println(s3 == s4);




//        Animal animal = new Animal();
//
//        Dog dog = new Dog();
//        System.out.println(dog.getName());
//        System.out.println(dog.getAge());
//
//        dog.setName("dog");
//
//        ArrayList<String> food = new ArrayList<>();
//        for (int i = 0; i < 3; i++){
//            food.add("食物" + i);
//        }
//
//        animal.setFood(food);
//
//        System.out.println(animal.getFood());
//        System.out.println(dog.getFood());






//        String threadName = Thread.currentThread().getName();
//        System.out.println(threadName + "start");
//
//        Thread1 thread1 = new Thread1();
//        Thread2 thread2 = new Thread2(thread1);
//
//        try{
//            thread1.start();
//            Thread.sleep(2000);
//            thread2.start();
//            thread2.join();
//        }catch (Exception e){
//
//        }
//        System.out.println(threadName + "end");



//        NewThread thread = new NewThread();
//        thread.start();
//
//        sleep(1147);
////        thread.interrupt();
//        thread.join();
//        System.out.println("线程已退出");



//        sleep(1147);
//        thread.exit = true;
//        thread.join();
//        System.out.println("线程退出");
//        String a = new String("abc");
//        String b = new String("abc");
//
//        final String aa = "abc";
//        String bb = "abc";
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                String cc = "abc";
//                System.out.println("子线程" + (cc == aa)); //子线程true
//            }
//        }).start();
//
//        System.out.println(a == b);  //false
//        System.out.println("主线程" + (aa == bb));//主线程true
//        System.out.println(a == bb); //false
//        System.out.println(b == aa); //false




//        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("/Users/user/Documents/inter/a.txt"));
//        //序列化对象
//        NewClass newClass = new NewClass("nihao",22);
//        newClass.setList("android");
//        out.writeObject("中国");
//        out.writeObject(new Date());
//        out.writeObject(newClass);
//        out.writeInt(888);
//        out.close();
//
//        ObjectInputStream in = new ObjectInputStream(new FileInputStream("/Users/user/Documents/inter/a.txt"));
//        System.out.println(in.readObject());
//        System.out.println(in.readObject());
//        NewClass newClass1 = (NewClass) in.readObject();
//        System.out.println(newClass1.getmName());
//        System.out.println(newClass);
//        System.out.println(newClass1);
//        newClass1.setList("java");
//        System.out.println(newClass.getList());
//        System.out.println(newClass1.getList());
//
//        System.out.println(in.readInt());
//        in.close();





//        NewClass newClass = new NewClass();
//        Class c = NewClass.class;
//        try {
//            //获取私有变量并赋值
//            Field field = c.getDeclaredField("mName");
//            field.setAccessible(true);
//            field.set(newClass,"zhongguo");
//            System.out.println(newClass.getmName());
//
//            //获取私有函数并执行
//            Method method = c.getDeclaredMethod("setmName",String.class);
//            method.setAccessible(true);
//            method.invoke(newClass,"shuibei");
//            System.out.println(newClass.getmName());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


//        Class c = NewClass.class;
//        try {
//            Constructor con = c.getConstructor(String.class);
//            try {
//                NewClass newClass = (NewClass) con.newInstance("baobao");
//                System.out.println(newClass.getmName());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }
//        Class<?> c = null;
//        try {
//            c = Class.forName("com.example.NewClass");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        NewClass newClass = null;
//        try {
//            newClass = (NewClass) c.newInstance();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        newClass.setmName("nihao");
//
//        System.out.println(newClass);
//        System.out.println(newClass.getmName());

//        NewClass newClass = new NewClass("Caicai");
//        newClass.setList("Java");
//        System.out.println(newClass.getmName());//Caicai
//        System.out.println(newClass.getList());//[Java]
//
//        NewClass newClass1 = null;
//
//        try {
//            newClass1 = (NewClass) newClass.clone();
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(newClass1.equals(newClass));//[Java]
//        System.out.println(newClass1.getList());//[Java]
//
//        newClass1.setList("Android");
//        System.out.println(newClass.getList());//[Java, Android]
//        System.out.println(newClass1.getList());//[Java, Android]







//        for (int i = 0; i < 20; i++){
//            executor.execute(new Task());
//        }
    }

//    static class Task implements Runnable{
//
//        @Override
//        public void run() {
//            System.out.println(Thread.currentThread().getName());
//        }
//    }
}
