package com.ncars.nacos.service;

import com.ncars.nacos.pojo.dto.UserDto;

public interface UserService {

    String findName();

    UserDto findById(Integer id);
}
