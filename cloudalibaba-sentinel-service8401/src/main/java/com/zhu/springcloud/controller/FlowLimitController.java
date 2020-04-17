package com.zhu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * 描述:
 * 流量控制的测试案例
 *
 * @author zhuchong
 * @create 2020-04-06 8:37
 */
@RestController
@Slf4j
public class FlowLimitController {
    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/testA")
    public String testA(){
        log.info("*************进入");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("*************出来");
        return "-------testA";
    }
    @GetMapping(value = "/testB")
    public String testB(){
        return "-------testB";
    }

    @GetMapping(value = "/testC")
    public String testC(){
        String forObject = restTemplate.getForObject("http://localhost:8401/testA", String.class);
        return "-------testC"+forObject;
    }

    @GetMapping(value = "/testD")
    public String testD(){
        log.info("测试RT 异常降级模式");
        int temp = 10 / 0;
        return "-------testD";
    }

    @GetMapping(value = "/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1" , required = false) String p1,
                             @RequestParam(value = "p2" , required = false) String p2){
        log.info("热点key降级" + p1+"--"+p2);
        //int age = 10/0;
        return "-------testHotKey";
    }

    public String deal_testHotKey(String p1, String p2, BlockException ex){
        return "限流了";
    }
}
