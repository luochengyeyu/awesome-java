package com.lcyy.example.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");
//        testThread();
//        testRunnable();
//        testCallable();
        int size = 5;
        for (int i = 0; i < size; ++i) {
            System.out.println(i);
        }
        for (int i = 0; i < size; i++) {
            System.out.println(i);
        }
    }

    private static void testCallable() {
        FutureTask<String> task = new FutureTask<>(new CallableTask());
        new Thread(task).start();
        try {
            String result = task.get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    private static void testThread() {
        //创建MyThread对象
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        //设置线程的名字
        t1.setName("001");
        t2.setName("002");

        //启动线程
        t1.start();
//        try {
//            t1.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        t2.start();

    }

    private static void testRunnable() {
        MyRunnable mr = new MyRunnable();
        //创建Thread类的有参构造,并设置线程名
        Thread t1 = new Thread(mr, "    线程 1");
        Thread t2 = new Thread(mr, "        线程 2");
        Thread t3 = new Thread(mr, "            线程 3");
        //启动线程
        t1.start();
        t2.start();
        t3.start();
    }
}