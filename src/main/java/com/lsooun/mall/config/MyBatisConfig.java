package com.lsooun.mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.lsooun.mall.mapper", "com.lsooun.mall.dao"})
public class MyBatisConfig {
}
