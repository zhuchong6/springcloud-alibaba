package com.zhu.springcloud.controller;

import com.zhu.springcloud.util.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 描述:
 * 调用微服务控制器
 *
 * @author zhuchong
 * @create 2020-04-05 9:28
 */
@RestController
@Slf4j
public class OrderNacosController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${server-url.nacos-user-service}")
    private String serverUrl;

    @GetMapping(value = "/consumer/echo/{string}")
    public String paymenInfo(@PathVariable String string){
        return restTemplate.getForObject(serverUrl+"/echo/"+string, String.class);
    }

    @GetMapping(value = "/consumer/paymentSql/{id}")
    public CommonResult paymentSql(@PathVariable("id") Long id) {
        return restTemplate.getForObject(serverUrl+"/paymentSql/"+id, CommonResult.class);
    }


}
