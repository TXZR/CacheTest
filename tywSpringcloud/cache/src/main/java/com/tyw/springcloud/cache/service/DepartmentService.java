package com.tyw.springcloud.cache.service;

import com.tyw.springcloud.cache.bean.Department;
import com.tyw.springcloud.cache.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = {"dep"})
public class DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Cacheable(key = "'dep' + #id")
    public Department getDep(Integer id){
        return departmentMapper.getDepById(id);
    }


}
