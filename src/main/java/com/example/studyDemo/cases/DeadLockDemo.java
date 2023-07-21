package com.example.studyDemo.cases;

import org.springframework.stereotype.Service;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * @Author: hao wu
 * @Date： 2023/1/31 22:05
 */
@Service
public class DeadLockDemo{
    private static Object resource1 = new Object();//资源 1
    private static Object resource2 = new Object();//资源 2

    private static int count;

    public void testDeadLock() {
        new Thread(() -> {
            synchronized (resource1) {
                System.out.println(Thread.currentThread() + "get resource1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get resource2");
                synchronized (resource2) {
                    System.out.println(Thread.currentThread() + "get resource2");
                }
            }
        }, "线程 1").start();

        new Thread(() -> {
            synchronized (resource2) {
                System.out.println(Thread.currentThread() + "get resource2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get resource1");
                synchronized (resource1) {
                    System.out.println(Thread.currentThread() + "get resource1");
                }
            }
        }, "线程 2").start();
    }

    public void test(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resource1){
                    System.out.println("t1 have resource1");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    synchronized (resource2){
                        System.out.println("t1 try r2");
                    }

                }
            }
        },"t1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resource2){
                    System.out.println("t2 have r2");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    synchronized (resource1){
                        System.out.println("t2 try r1");
                    }
                }
            }
        },"t2").start();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        DeadLockDemo deadLockDemo = new DeadLockDemo();
//        deadLockDemo.test();


        for (int i=0;i<20;i++){

            new Thread(new task(),"t"+i).start();
//            new task();
//            new task1().start();
//            FutureTask<Integer> futureTask = new FutureTask<>(new task2());
//            new Thread(futureTask).start();
//            int res = futureTask.get();
//            System.out.println(res);
        }
    }

    static class task implements Runnable{

        @Override
        public void run() {
            count++;
            System.out.println("current thread:"+Thread.currentThread().getName()+"----"+count);
        }
    }

    static class task1 extends Thread{

        @Override
        public void run() {
            count++;
            System.out.println("current thread"+Thread.currentThread().getName()+"----"+count);
        }
    }

    static class task2 implements Callable<Integer> {

        @Override
        public Integer call() {
            count++;
            System.out.println("current "+Thread.currentThread().getName()+"----"+count);
            return count;
        }
    }
}