package com.example.studyDemo.cases.rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * @Author: hao wu
 * @Date： 2023/2/16 20:39
 */
public class RmiServer {
    public static void main(String[] args) {

        try {
            System.setProperty("java.rmi.server.hostname","192.168.79.128");
            System.out.println("正在运行中1099---192.168.79.128...");
            // 将服务注册到8888端口
            RmiDemoService rmiDemoService = new RmiDemoServiceImpl();
            LocateRegistry.createRegistry(1099);
            // 把接口实例绑定到端口的一个路径上
            Naming.bind("rmi://127.0.0.1:1099/HELLO_RMI", rmiDemoService);

            System.out.println("======= 启动RMI服务成功! =======");
        }catch (Exception e){
            System.out.println("注册远程对象失败，错误信息：" + e.getMessage());
        }

    }
}
