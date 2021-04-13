package com.ncars.nacos.service.impl;

import com.ncars.nacos.pojo.dto.UserDto;
import com.ncars.nacos.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class UserServiceImpl implements UserService {

    @HystrixCommand()
    @Override
    public String findName() {
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        return "abc ddd anb";
    }

    @Override
    public UserDto findById(Integer id) {
        int i =1/0;
        return UserDto.builder().name("张珊珊").build();
    }
}
