package com.wetrol.testdemo.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;


@Data
@TableName("userlogininfo")
public class UserLoginInfo {

    @TableId(type = IdType.AUTO)
    private Long userLoginId;
    private Long userId;
    private Date userLoginDate;

}
