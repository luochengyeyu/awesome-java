package com.lcyy.example.thread;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        // 同步代码快
        synchronized (MyRunnable.class) {
            System.out.println(Thread.currentThread().getName() + " 类锁");
        }
    }

    private static synchronized void say(){
        System.out.println("静态同步方法");
    }
}