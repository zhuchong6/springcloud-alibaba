package com.zhu.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 描述:
 * restTemplate Config
 *
 * @author zhuchong
 * @create 2020-04-07 1:16
 */
@Configuration
public class Config {

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
