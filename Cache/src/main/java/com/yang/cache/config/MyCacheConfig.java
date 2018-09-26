package com.yang.cache.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

public class MyCacheConfig {

    @Bean("myKeyGenerator")
    public KeyGenerator keyGenerator(){
        return (o, method, objects) -> method.getName()+"["+ Arrays.asList(objects)+"]";
    }
}
