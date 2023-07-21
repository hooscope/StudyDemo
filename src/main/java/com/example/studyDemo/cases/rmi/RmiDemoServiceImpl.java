package com.example.studyDemo.cases.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @Author: hao wu
 * @Date： 2023/2/16 20:37
 */
public class RmiDemoServiceImpl extends UnicastRemoteObject implements RmiDemoService{

    protected RmiDemoServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public String sayHello(String name) throws RemoteException {

        return "hello "+name;
    }
}
