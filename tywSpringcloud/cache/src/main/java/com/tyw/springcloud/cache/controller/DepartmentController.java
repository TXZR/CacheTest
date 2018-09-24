package com.tyw.springcloud.cache.controller;

import com.tyw.springcloud.cache.bean.Department;
import com.tyw.springcloud.cache.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @RequestMapping("/dep/{id}")
    public Department getDep(@PathVariable Integer id){
        return service.getDep(id);
    }

}
