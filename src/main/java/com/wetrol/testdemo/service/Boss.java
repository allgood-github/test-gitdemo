package com.wetrol.testdemo.service;

import com.wetrol.testdemo.service.impl.Person;
import lombok.Data;

@Data
public class Boss implements Person {
    private String name;
    private Integer Age;
}
