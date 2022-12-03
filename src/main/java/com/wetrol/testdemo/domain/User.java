package com.wetrol.testdemo.domain;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {


    private String username;
    private String gender;
    private Integer age;
    private String[] likes;


}
