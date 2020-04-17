package com.zhu.springcloud.service;

import com.zhu.springcloud.util.CommonResult;
import com.zhu.springcloud.domain.Payment;
import org.springframework.stereotype.Component;

/**
 * 描述:
 * 处理异常类
 *
 * @author zhuchong
 * @create 2020-04-07 5:06
 */
@Component
public class PaymentFallbackService implements PaymentFeignService {
    @Override
    public CommonResult paymentSql(Long id) {
        return new CommonResult(444, "feign 服务降级返回", new Payment(id,null));
    }
}
