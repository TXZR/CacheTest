package com.tyw.springcloud.cache.controller;

import com.tyw.springcloud.cache.bean.Employee;
import com.tyw.springcloud.cache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("emp/{id}")
    public Employee getEmp(@PathVariable Integer id){
        return employeeService.getEmp(id);
    }

    @RequestMapping("emp/update")
    public Employee updateEmp(Employee employee){
        return employeeService.updateEmp(employee);
    }

    @RequestMapping("emp/delete/{id}")
    public void deleteEmp(@PathVariable Integer id){
        employeeService.deleteEmp(id);
    }

}
