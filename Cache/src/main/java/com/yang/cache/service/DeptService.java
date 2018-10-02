package com.yang.cache.service;

import com.yang.cache.bean.Department;
import com.yang.cache.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class DeptService {
    @Autowired
    DepartmentMapper departmentMapper;

    @Cacheable(cacheNames = "dept")
    public Department getDept(Integer id){
        System.out.println("查询部门"+id);
        Department department = departmentMapper.getDeptById(id);
        return department;
    }
}
