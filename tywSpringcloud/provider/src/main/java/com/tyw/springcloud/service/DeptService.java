package com.tyw.springcloud.service;

import com.tyw.springcloud.entities.Dept;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DeptService {
    boolean addDept(Dept dept);

    Dept findById(Long id);

    List<Dept> findAll();
}
