package com.example.studyDemo.cases;

import org.springframework.context.ApplicationEvent;

/**
 * @Author: hao wu
 * @Date： 2023/2/2 14:35
 * Spring 的事件流程 观察者模式
 */

// 定义一个事件,继承自ApplicationEvent并且写相应的构造函数
public class DemoEvent extends ApplicationEvent {
    private static final long serialVersionUID = 1L;

    private String message;

    public DemoEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

