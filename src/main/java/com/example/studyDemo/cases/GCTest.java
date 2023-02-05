package com.example.studyDemo.cases;

/**
 * @Author: hao wu
 * @Date： 2023/1/31 22:30
 */
public class GCTest {

    public static void main(String[] args) {
        byte[] allocation1, allocation2,allocation3,allocation4,allocation5;
        allocation1 = new byte[52000*1024];
        allocation2 = new byte[12000*1024];
        allocation3 = new byte[1000*1024];
        allocation4 = new byte[1000*1024];
        allocation5 = new byte[1000*1024];
    }
}
