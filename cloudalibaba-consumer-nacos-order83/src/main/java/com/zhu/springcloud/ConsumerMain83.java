package com.zhu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 描述:
 * 微服务消费者
 *
 * @author zhuchong
 * @create 2020-04-05 9:27
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerMain83 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerMain83.class, args);
    }
}
