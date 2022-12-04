package com.wetrol.testdemo.controller.druid;


import com.alibaba.druid.stat.DruidStatManagerFacade;
import com.alibaba.druid.wall.WallConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Api(tags = "测试Druid的监控面板")
@RestController
@RequestMapping("/api/druid")
public class DruidStatController {

    /**
     * wall
     * @return
     */
    @ApiOperation("测试Druid中的Wall")
    @GetMapping("/wall")
    public Object druidWall(){
        WallConfig wallConfig = new WallConfig();

        return wallConfig;
    }


   /*
    List<Map<String,Object>> Swagger2 不能解析这个返回值。如果将Object返回值设置为具体的List<Map<String,Object>>会报错，如下
    Could not resolve reference because of: Could not resolve pointer: /definitions/Map«string,object» does not exist in document


    @ApiOperation("Stat中的信息")
    @GetMapping("/stat")
    public List<Map<String,Object>> druidStat(){
        List<Map<String,Object>> dataSourceStatDataList = DruidStatManagerFacade.getInstance().getDataSourceStatDataList();
        return dataSourceStatDataList;
    }*/
    @ApiOperation("测试Druid中Stat的信息2")
    @GetMapping("/stat2")
    public Object druidStat2(){
        List<Map<String,Object>> dataSourceStatDataList = DruidStatManagerFacade.getInstance().getDataSourceStatDataList();
        return dataSourceStatDataList;
    }

}
