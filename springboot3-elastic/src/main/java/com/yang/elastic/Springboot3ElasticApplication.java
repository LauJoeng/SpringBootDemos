package com.yang.elastic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot默认支持两种方式和ES交互
 * 1.Jest
 * 2.SpringData ElasticSearch[ES版本可能不合适]
 *      1).Client 节点信息clusterNodes，clusterName
 *      2).ElasticsearchTemplate操作ES
 *      3).编写一个ElasticsearchRepository的子接口来操作ES
 */
@SpringBootApplication
public class Springboot3ElasticApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot3ElasticApplication.class, args);
    }
}
