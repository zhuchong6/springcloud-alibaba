package com.zhu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.zhu.springcloud.util.CommonResult;
import com.zhu.springcloud.exception.GlobalException;
import com.zhu.springcloud.exception.SentinelExceptionHandler;
import com.zhu.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 描述:
 * sentinel限流配置测试
 *
 * @author zhuchong
 * @create 2020-04-07 3:53
 */
@RestController
@Slf4j
public class OrderNacosController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${server-url.nacos-user-service}")
    private String serverUrl;

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/paymentSql/{id}")
    public CommonResult paymentSql(@PathVariable("id") Long id) {
        return restTemplate.getForObject(serverUrl+"/paymentSql/"+id, CommonResult.class);
    }


    @GetMapping(value = "/consumer/fallback/{id}")
//    @SentinelResource(value = "fallback")
//    @SentinelResource(value = "fallback",
////            fallbackClass = GlobalException.class,
////            fallback = "exception1")
//    @SentinelResource(value = "fallback",
//            blockHandlerClass = SentinelExceptionHandler.class,
//            blockHandler = "fallback")
    @SentinelResource(value = "fallback",
            fallbackClass = GlobalException.class,
            fallback = "exception1",
            blockHandlerClass = SentinelExceptionHandler.class,
            blockHandler = "fallback"
    )
    public CommonResult fallback(@PathVariable("id") Long id) {
        CommonResult forObject = restTemplate.getForObject(serverUrl + "/paymentSql/" + id, CommonResult.class);
        if(id ==7){
            throw  new IllegalArgumentException("参数异常");
        }else if(forObject.getData() == null){
            throw  new NullPointerException("空指针异常");
        }
        return forObject;
    }


    /**
     * feign集成了sentinel的流量控制，服务熔断降，默认是以url方式
     * @param id
     * @return
     */
    @GetMapping(value = "/consumer/feignType/{id}")
    public CommonResult feignType(@PathVariable("id") Long id) {
        return paymentFeignService.paymentSql(id);
    }


}
