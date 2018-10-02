package com.yang.cache;

import com.yang.cache.bean.Employee;
import com.yang.cache.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CacheApplicationTests {

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate;//操作k-v都是字符串的

    @Autowired
    RedisTemplate redisTemplate;//操作k-v都是对象的

    @Autowired
    RedisTemplate<Object,Employee> empRedisTemplate;

    /**
     * Redis常见五大数据类型
     * String，List，Set，Hash，ZSet(有序集合)
     */
    @Test
    public void test01(){
        //给redis保存了一个数据
//        stringRedisTemplate.opsForValue().append("msg","hello");
        String msg = stringRedisTemplate.opsForValue().get("msg");

        stringRedisTemplate.opsForList().leftPush("mylist","1");
        stringRedisTemplate.opsForList().leftPush("mylist","2");
        System.out.println(msg);
    }

    @Test
    public void test02(){
        Employee employee = employeeMapper.getEmpById(1);
        //保存对象默认使用jdk序列化机制，将序列化后的对象保存到redis中
        redisTemplate.opsForValue().set("emp01",employee);
        //1.将数据以json方式保存，可以自己转换后在保存
        empRedisTemplate.opsForValue().set("emp01",employee);
    }

    @Test
    public void contextLoads() {
        Employee employee = employeeMapper.getEmpById(1);
        System.out.println(employee);
    }

}
