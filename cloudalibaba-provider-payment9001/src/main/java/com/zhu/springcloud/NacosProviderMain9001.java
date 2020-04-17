package com.zhu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 描述:
 * SpringCloudAlibaba nacos 服务提供者
 *
 * @author zhuchong
 * @create 2020-04-05 8:57
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosProviderMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(NacosProviderMain9001.class, args);
    }
}
