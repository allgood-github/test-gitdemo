package com.wetrol.testdemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wetrol.testdemo.dao.UserLoginInfoDao;
import com.wetrol.testdemo.domain.UserLoginInfo;
import com.wetrol.testdemo.service.UserLoginInfoService;
import org.springframework.stereotype.Service;

@Service
public class UserLoginInfoServiceImpl extends ServiceImpl<UserLoginInfoDao, UserLoginInfo> implements UserLoginInfoService {

}
