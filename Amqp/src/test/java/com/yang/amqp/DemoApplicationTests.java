package com.yang.amqp;

import com.yang.bean.Book;
import com.yang.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
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

    @Autowired
    AmqpAdmin amqpAdmin;

    @Test
    public void createExchange(){
//        amqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange"));
//        amqpAdmin.declareQueue(new Queue("amqpadminQueue",true));
        amqpAdmin.declareBinding(new Binding("amqpadminQueue", Binding.DestinationType.QUEUE,"amqpadmin.exchange","amqp.haha",null));
        System.out.println("创建完成");
    }
    /**
     * 单播
     */
    @Test
    public void contextLoads() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg","first rabbitmq msg");
        map.put("data", Arrays.asList("hello","world","true","false"));
        //对象默认被序列化后发送
//        rabbitTemplate.convertAndSend("exchange.direct","yang.news",map);
//        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        rabbitTemplate.convertAndSend("exchange.direct","yang.news",new Book("三国演义","罗贯中"));
    }

    @Test
    public void receive(){
        Object o = rabbitTemplate.receiveAndConvert("yang.news");
        System.out.println(o.getClass());
        System.out.println(o);
    }

}
