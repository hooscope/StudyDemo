package com.example.studyDemo.cases.rmi;

import java.rmi.Naming;

/**
 * @Author: hao wu
 * @Date： 2023/2/16 21:06
 */
public class RmiClient {
    public static void main(String[] args) {
        try {

            System.out.println("启动rmi客户端...");
            // 通过RMI发现服务并且转成一个对象
            RmiDemoService demoService = (RmiDemoService) Naming.lookup("rmi://192.168.79.128:1099/HELLO_RMI");
            // 远程调用下服务方法
            System.out.println(demoService.sayHello("RMI"));
        } catch (Exception e) {
            System.out.println("调用远程对象失败，错误信息：" + e.getMessage());
        }
    }

}
