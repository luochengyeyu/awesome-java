package com.lcyy.example.thread;

import java.util.concurrent.Callable;

public class CallableTask implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "Hello,i am running!";
    }
}
