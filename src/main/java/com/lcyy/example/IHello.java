package com.lcyy.example;

public interface IHello {

    void print();

    default void hello() {
        System.out.println("IHello.hello()");
    }

    static void word(){
        System.out.println("IHello.word()");
    }
}
