package com.lcyy.example.generics;

import java.util.ArrayList;
import java.util.List;

public class Main {
    // 定义一个泛型方法
    public static <T> void printArray(T[] inputArray) {
        for (T element : inputArray) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }

    public static void main(String args[]) {
        // 创建不同类型数组： Integer, Double 和 Character
        Integer[] intArray = {1, 2, 3, 4, 5};
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4};
        Character[] charArray = {'H', 'E', 'L', 'L', 'O'};

        System.out.println("整型数组内容:");
        printArray(intArray);

        System.out.println("双精度型数组内容:");
        printArray(doubleArray);

        System.out.println("字符型数组内容:");
        printArray(charArray);
    }
}

