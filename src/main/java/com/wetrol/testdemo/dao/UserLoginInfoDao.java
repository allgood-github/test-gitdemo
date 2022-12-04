package com.wetrol.testdemo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wetrol.testdemo.domain.UserLoginInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserLoginInfoDao extends BaseMapper<UserLoginInfo> {

}
