package com.lcyy.example;

public class Fibonacci {
    private static long count;
    private static long count2;

    public static void main(String[] args) {
        int fibonacci = fibonacci(5);
        System.out.println(fibonacci);
//
        int fibonacciMemorized = fibonacciMemorized(5);
        System.out.println(fibonacciMemorized);

        int fibonacci2 = fibonacci2(5);
        System.out.println(fibonacci2);
    }

    // 求第 n 个斐波那契数
    private static int fibonacci(int n) {
        if (n == 0) return 0; // 返回 f(0)
        if (n == 1) return 1; // 返回 f(1)
        count += 1;
        System.out.println("递归执行次数：" + count);
        return fibonacci(n - 1) + fibonacci(n - 2); // 分解为两个子问题求解
    }

    static int fibonacci(int n, int[] dp) {
        if (n == 0) return 0;           // 返回 f(0)
        if (n == 1) return 1;           // 返回 f(1)
        if (dp[n] != 0) return dp[n];   // 若 f(n) 以前已经计算过，则直接返回记录的解

        count2 += 1;
        System.out.println("递归执行次数：" + count2);

        dp[n] = fibonacci(n - 1, dp) + fibonacci(n - 2, dp); // 将 f(n) 则记录至 dp
        return dp[n];
    }


    // 求第 n 个斐波那契数
    static int fibonacciMemorized(int n) {
        int[] dp = new int[n + 1]; // 用于保存 f(0) 至 f(n) 问题的解
        return fibonacci(n, dp);
    }

    // 求第 n 个斐波那契数
    static int fibonacci2(int n) {
        if (n == 0) return 0;           // 若求 f(0) 则直接返回 0
        int a = 0, b = 1;               // 初始化 f(0), f(1)
        for (int i = 2; i <= n; i++) {  // 状态转移求取 f(2), f(3), ..., f(n)
            int tmp = a;
            a = b;
            b = tmp + b;
        }
        return b;               // 返回 f(n)
    }
}
