package com.example.studyDemo.cases.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @Author: hao wu
 * @Date： 2023/2/16 20:36
 */
public interface RmiDemoService extends Remote {

    String sayHello(String name) throws RemoteException;
}
