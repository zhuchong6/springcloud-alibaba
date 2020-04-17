package com.zhu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 描述:
 * 启动类
 *
 * @author zhuchong
 * @create 2020-04-07 3:52
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class OrderMain85 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain85.class, args);
    }
}
