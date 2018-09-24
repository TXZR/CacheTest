package com.tyw.springcloud.cache.service;

import com.tyw.springcloud.cache.bean.Employee;
import com.tyw.springcloud.cache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames="emp")
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Cacheable(key = "'emp' + #id")
    public Employee getEmp(Integer id){
        return employeeMapper.getEmpById(id);
    }

    @CachePut(key ="'emp' + #employee.id")
    public Employee updateEmp(Employee employee){
        employeeMapper.updateEmp(employee);
        return employee;
    }

    @CacheEvict(key = "'emp' + #id")
    public void deleteEmp(Integer id){

    }

}
