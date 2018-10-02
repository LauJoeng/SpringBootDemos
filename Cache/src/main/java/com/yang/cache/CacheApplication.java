package com.yang.cache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 搭建基本环境
 * 1.导入数据库文件，创建出department和employee表
 * 2.创建javaBean封装数据
 * 3.整合Mybatis操作数据库
 *      1.配置数据源信息
 *      2.使用注解版MyBatis
 *          1）、@MapperScan制定需要扫描的mapper接口
 * 快速体验缓存
 *      步骤：
 *          1、开启基于注解的缓存
 *          2、标注缓存注解即可
 *              @Cacheable
 *              @CacheEvict
 *              @CachePut
 *
 * 默认使用的是ConcurrentMapCacheManager=ConcurrentMapCache，将数据保存在ConcurrentHashMap中
 * 开发使用中间件，redis，memcache
 *整合redis
 * 1.使用docker安装redis
 * 2.引入redis的starter
 * 3.配置redis
 * 4.测试缓存
 *          CacheManager==Cache缓存组件来实际给缓存中取出数据
 *          引入Redis的starter，容器中保存的是RedisCacheManager，其他CacheManager不起作用
 *      需自定义CacheManger才能实现用json的数据形式缓存到redis
 *
 *
 * 整合redis作为缓存
 * 安装redis，使用docker安装
 */

@MapperScan("com.yang.cache.mapper")
@SpringBootApplication
@EnableCaching
public class CacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(CacheApplication.class, args);
    }
}
