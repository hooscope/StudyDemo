package com.example.studyDemo.service;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.studyDemo.cases.DeadLockDemo;
import com.example.studyDemo.entity.TDeviceInfo;
import com.example.studyDemo.mapper.TDeviceInfoMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class DemoService {

    TDeviceInfoMapper tDeviceInfoMapper;

    DeadLockDemo deadLockDemo;

    public List<TDeviceInfo> test(){
        LambdaQueryWrapper<TDeviceInfo> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TDeviceInfo::getId,1);
        List<TDeviceInfo> tDeviceInfos = tDeviceInfoMapper.selectList(wrapper);
        log.info("test info {}",tDeviceInfos.size());
        log.debug("test debug {}",tDeviceInfos.size());
        log.trace("test trace {}",tDeviceInfos.size());
        log.warn("test warn {}",tDeviceInfos.size());
        log.error("test error {}",tDeviceInfos.size());
        return tDeviceInfos;

    }

    public void testDeadLock(){
        deadLockDemo.testDeadLock();
    }

}
