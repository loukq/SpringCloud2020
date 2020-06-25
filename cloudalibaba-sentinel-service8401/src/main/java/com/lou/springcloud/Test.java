package com.lou.springcloud;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池的测试demo
 */
public class Test {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(3, 50, 1000l, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(1000),new ThreadPoolExecutor.AbortPolicy()) {
        };

        for (int i=0;i<20;i++){
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {

                    System.out.println(Thread.currentThread().getName());

                    System.out.println("hello world");
                    try {
                        Thread.currentThread().sleep(1000l);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            });


        }

        threadPoolExecutor.shutdown();


    }
}
