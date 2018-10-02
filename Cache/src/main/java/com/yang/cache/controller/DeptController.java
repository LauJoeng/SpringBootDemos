package com.yang.cache.controller;

import com.yang.cache.bean.Department;
import com.yang.cache.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {

    @Autowired
    DeptService deptService;

    @GetMapping("/dept/{id}")
    public Department getDept(@PathVariable("id")Integer id){
        Department dept = deptService.getDept(id);
        return dept;
    }
}
