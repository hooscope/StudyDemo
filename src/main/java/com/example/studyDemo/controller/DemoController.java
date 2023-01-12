package com.example.studyDemo.controller;

import com.example.studyDemo.entity.TDeviceInfo;
import com.example.studyDemo.result.Result;
import com.example.studyDemo.result.ResultGenerator;
import com.example.studyDemo.service.DemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("测试")
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    DemoService demoService;

    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);

    @GetMapping("/test")
    public List<TDeviceInfo> test() {


        List<TDeviceInfo> infos = demoService.testMysql();
        return infos;
    }

    @ApiOperation(value = "测试mysql")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功"))
    @RequestMapping(value = "testMysql", method = RequestMethod.GET)
    public Result<List<TDeviceInfo>> testMysql(){
        logger.debug("=====>测试日志debug级别打印<==test git merge==");
        logger.info("=====>测试日志info级别打印<=====");
        logger.error("=====>测试日志error级别打印<====");
        logger.warn("=====>测试日志warn级别打印<=====");
        logger.warn("=====>test git merge<=====");
        List<TDeviceInfo> infos = demoService.testMysql();
        return ResultGenerator.genSuccessResult(infos);
    }

    @ApiOperation(value = "测试redis")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功"))
    @RequestMapping(value = "testRedis", method = RequestMethod.GET)
    public Result<String> testRedis(@RequestParam(value = "name") String name){
        return ResultGenerator.genSuccessResult(demoService.testRedis(name));
    }

    @RequestMapping(value = "testpost", method = RequestMethod.POST)
    public String testPostRequest(){
        return "456";
    }
}
