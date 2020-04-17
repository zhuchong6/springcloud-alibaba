package com.zhu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 描述:
 * 订单服务启动类
 *
 * @author zhuchong
 * @create 2020-04-11 12:14
 */

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)//取消数据源自动配置
public class OderMain2001 {
    public static void main(String[] args) {
        SpringApplication.run(OderMain2001.class, args);
    }
}
