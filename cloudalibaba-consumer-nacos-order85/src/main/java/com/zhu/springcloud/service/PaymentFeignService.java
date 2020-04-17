package com.zhu.springcloud.service;

import com.zhu.springcloud.util.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 描述:
 * feign接口
 *
 * @author zhuchong
 * @create 2020-04-07 5:02
 */
@FeignClient(value = "nacos-payment-provider", fallback = PaymentFallbackService.class)
public interface PaymentFeignService {
    /**
     * 调用服提供者方法
     * @param id
     * @return
     */
    @GetMapping(value = "/paymentSql/{id}")
    CommonResult paymentSql(@PathVariable("id") Long id);
}
