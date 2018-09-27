package com.yang.cache.service;

import com.yang.cache.bean.Employee;
import com.yang.cache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

@CacheConfig(cacheNames = "emp")//抽取缓存的公共配置
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
    @Cacheable(cacheNames = "emp",key = "#id",unless = "#result == null")
//    @Cacheable(keyGenerator = "myKeyGenerator")
    public Employee getEmp(Integer id){
        System.out.println("查询"+id+"号员工");
        Employee emp = employeeMapper.getEmpById(id);
        return emp;
    }

    /**
     * CachePut:既调用方法，又更新缓存数据
     * 修改了数据库某个数据，同时又更新缓存
     *
     * 运行时机与Cacheable不同，是先调用方法在把值存入缓存
     * 这里让key与上面的一样，在调用方法更新后就会同时更新缓存中的值，如果没有设置的话，缓存会用参数最为key，
     * 即传入的employee对象做为key加入缓存，这样再次调用查询方法查询到的结果还是更新前的值
     */
    @CachePut(key = "#employee.id")
    public Employee updateEmployee(Employee employee){
        System.out.println("update emp:"+employee);
        employeeMapper.update(employee);
        return employee;
    }

    /**
     * CacheEvict:缓存清除
     * key:指定要清除的数据，value指定缓存名字
     * allEntries：是否删除全部key的数据
     * beforeInvocation:缓存的清楚是否在方法之前执行，默认在方法之后
     */
    @CacheEvict(value = "emp")
    public void deleteEmp(Integer id){
        System.out.println("delete:"+id);
        employeeMapper.deleteEmpById(id);
    }

    /**
     * @Caching 定义复杂规则的缓存规则
     * @param lastName
     * @return
     */
    @Caching(
            cacheable = {
                    @Cacheable(value = "emp",key = "#lastName")
            },
            put = {
                    @CachePut(value = "emp",key = "#result.id"),
                    @CachePut(value = "emp",key = "#result.email")
            }
    )
    public Employee getEmpByLastName(String lastName){
        return employeeMapper.getEmpByLastName(lastName);
    }
}
