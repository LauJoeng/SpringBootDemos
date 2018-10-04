package com.yang.amqp;

import com.yang.service.BookService;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * RabbiAutoConfiguration
 *
 * 配置了连接工厂ConnectionFactory
 * RabbitProperties封装了RabbitMQ的配置
 * RabbitTemplate:给RabbitMQ发送和接收消息
 * AmqpAdmin：Rabbit系统管理组建
 *
 *@ EnableRabbit+@RabbitListener里的内容
 *
 */
@EnableRabbit//开启基于注解的RabbitMQ模式
@SpringBootApplication
public class DemoApplication {


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
