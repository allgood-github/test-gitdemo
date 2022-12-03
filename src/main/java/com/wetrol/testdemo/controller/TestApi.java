package com.wetrol.testdemo.controller;

import com.wetrol.testdemo.domain.MyCar;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(tags = "测试汽车和M1方法")
@Controller
@RequestMapping("/test")
public class TestApi {

    String s = "测试代码，假的";

    @Autowired
    MyCar myCar;

    @ApiOperation("测试m1")
    @GetMapping("/m1")
    @ResponseBody
    public String test1(@RequestParam(name = "name" ,required = false) @ApiParam("输入名字") String name){
        return "测试数据：" + name;
    }

    @ApiOperation("测试小汽车")
    @GetMapping("/car")
    @ResponseBody
    public String testm2(){
        return "小汽车车：" + myCar;
    }
}
