package com.example.studyDemo;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.studyDemo.entity.TDeviceInfo;
import com.example.studyDemo.mapper.TDeviceInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class DemoApplicationTests {


    @Autowired
    private TDeviceInfoMapper tDeviceInfoMapper;

    @Test
    public void test(){
        LambdaQueryWrapper<TDeviceInfo> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TDeviceInfo::getId,1);
        List<TDeviceInfo> tDeviceInfos = tDeviceInfoMapper.selectList(wrapper);
        tDeviceInfos.forEach(System.out::println);
        log.info("test info {}",tDeviceInfos.size());
        log.debug("test debug {}",tDeviceInfos.size());
        log.trace("test trace {}",tDeviceInfos.size());
        log.warn("test warn {}",tDeviceInfos.size());
        log.error("test error {}",tDeviceInfos.size());
        System.out.println(IdUtil.getSnowflakeNextId());

    }

}
