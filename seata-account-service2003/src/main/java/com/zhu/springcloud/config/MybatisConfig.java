package com.zhu.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * 描述:
 * mybatis config
 *
 * @author zhuchong
 * @create 2020-04-11 13:35
 */
@Configuration
@MapperScan({"com.zhu.springcloud.dao"})
public class MybatisConfig {
}
