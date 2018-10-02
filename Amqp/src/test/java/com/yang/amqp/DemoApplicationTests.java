package com.yang.amqp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;


    /**
     * 单播
     */
    @Test
    public void contextLoads() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg","first rabbitmq msg");
        map.put("data", Arrays.asList("hello","world","true","false"));
        //对象默认被序列化后发送
        rabbitTemplate.convertAndSend("exchange.direct","yang.news",map);
    }

    @Test
    public void receive(){
        Object o = rabbitTemplate.receiveAndConvert("yang.news");
        System.out.println(o.getClass());
        System.out.println(o);
    }

}
