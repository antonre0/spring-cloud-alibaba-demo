package com.ncars.nacos.service.impl;

import com.ncars.nacos.service.UserService;

@org.apache.dubbo.config.annotation.Service
public class UserServiceImpl implements UserService {

    @Override
    public String findName() {
        return "abc ddd anb";
    }
}
