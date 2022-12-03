package com.wetrol.testdemo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wetrol.testdemo.domain.UserLoginInfo;
import com.wetrol.testdemo.service.UserLoginInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserLoginInfoController {


    @Autowired
    UserLoginInfoService userLoginInfoService;


    /**
     * 分页查询
     */


    /**
     * 根据 userId查询信息
     * @param userid
     * @return
     */
    @GetMapping("/getLoginInfo/{userid}")
    public UserLoginInfo testUserLoginInfo(@RequestParam(value = "userName",defaultValue = "李思思") String userName,
                                           @PathVariable("userid") Long userId){

        QueryWrapper<UserLoginInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userId",userId);
        log.info("UserLoginInfoController::testUserLoginInfo ==> userId: " + userId +"\n userName: ==> " + userName);
        UserLoginInfo info = userLoginInfoService.getOne(queryWrapper);

        return info;
    }


}
