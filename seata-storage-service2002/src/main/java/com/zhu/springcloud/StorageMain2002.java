package com.zhu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 描述:
 * 库存主启动类
 *
 * @author zhuchong
 * @create 2020-04-14 16:36
 */
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)//取消数据源自动配置
public class StorageMain2002 {
    public static void main(String[] args) {
        SpringApplication.run(StorageMain2002.class, args);
    }
}
