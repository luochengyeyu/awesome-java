package com.lcyy.example;

public class SingleInstance {
    // volatile修饰禁止 JVM 的指令重排，保证在多线程环境下也能正常初始化对象。
    private volatile static SingleInstance instance;

    private SingleInstance() {
    }

    public static SingleInstance getInstance() {
        if (instance == null) {
            synchronized (SingleInstance.class){
                if (instance == null) {
                    instance = new SingleInstance();
                }
            }
        }
        return instance;
    }
}
