package com.ncars.nacos;

import com.ncars.nacos.pojo.dto.UserDto;
import org.apache.dubbo.common.serialize.support.SerializationOptimizer;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class SerializationOptimizerImpl implements SerializationOptimizer {
    @Override
    public Collection<Class<?>> getSerializableClasses() {
        List<Class<?>> classes = new LinkedList<Class<?>>();
        classes.add(UserDto.class);
        return classes;
    }
}
