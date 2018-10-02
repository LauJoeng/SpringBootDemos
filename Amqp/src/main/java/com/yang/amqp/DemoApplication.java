package com.yang.amqp;

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
 */
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
