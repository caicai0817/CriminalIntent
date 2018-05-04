package com.caicai.criminalintent.design.aaSingleton;

import java.io.Serializable;

/**
 * @author Caicai.
 * @date 2018/4/23.
 * @description 单例模式之double check lock
 *
 * 为什么在synchronized中为什么还有一个非空判断? 这个就需要解释一下singleton = new Singleton()语句, 代码会编译成对跳汇编指令,大致做三件事情
 * [1] 给Singleton的实例分配内存
 * [2] 调用Singleton的构造函数,初始化成员字段
 * [3] 将singleton对象指向分配的内存空间(此时singleton就不是null了)
 * 在jdk1.5之前,上面的[2]和[3]的顺序是无法保证的,如果顺序是1-3-2,那么执行完[3]未执行[2]就切换到其他线程直接取走singleton,在使用就会出错.
 */

public class Singleton {
    private static Singleton singleton;
    private Singleton(){}
    public static Singleton getSingleton(){
        if (singleton == null){
            synchronized (Singleton.class){
                if (singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
