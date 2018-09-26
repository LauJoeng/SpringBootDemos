package com.yang.cache.service;

import com.yang.cache.bean.Employee;
import com.yang.cache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;
    /**
     *   这个注解能将方法的运行结果进行缓存，以后再要相同的数据就直接从缓存中获取，不再调用方法
     *   几个属性
     *  cacheNames/value,指定缓存的名字:将方法返回结果放在哪个缓存中是数组的方式
     *  key：缓存数据使用的key，可以用它来指定。默认是使用方法参数的值，可以使用spel表达式
     *  keyGenerator:key的生成器，可以指定自己的key的生成器组建id，这个和key二选一使用
     *  cacheManager：指定缓存管理器，或者指定缓存解析器cacheResolver，也是二选一
     *  condition：指定符合条件情况下才缓存   如：condition="#a0>1"   第一个参数大于1才缓存
     *  unless:否定缓存，与condition相反
     *  sync:是否使用异步缓存
     *
     *  原理
     *      1、自动配置类:CacheAutoConfiguration
     *      2、缓存配置类
     *  运行流程:
     *      1、方法运行之前，先去查询Cache(缓存组建),按照cacheNames指定的名字获取(CacheManager先获取相应的缓存)，
     *          第一次获取缓存如果没有Cache组建会自动创建
     *      2.去Cache中查找缓存，使用一个key，默认就是方法参数。key是按照某种策略生成的。
     *      3.没有缓存就调用目标方法，将目标方法返回的结果放入缓存
     *
     *  @Cacheable 标注的方法执行之前先会检查缓存有没有这个数据，默认按照参数的值作为key去查询缓存。如果没有就调用方法将查询结果放入缓存
     */
//    @Cacheable(cacheNames = "emp",key = "#id",condition = "#id>0",unless = "#result == null")
    @Cacheable(keyGenerator = "myKeyGenerator")
    public Employee getEmp(Integer id){
        System.out.println("查询"+id+"号员工");
        Employee emp = employeeMapper.getEmpById(id);
        return emp;

    }
}
