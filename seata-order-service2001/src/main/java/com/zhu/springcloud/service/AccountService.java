package com.zhu.springcloud.service;

import com.zhu.springcloud.util.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * feign接口调用账户微服务
 * @author zhuchong
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {

    /**
     * 扣减库存
     * @param userId 用户id
     * @param money 扣减金钱
     * @return
     */
    @PostMapping(value = "/account/decrease")
    CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);


}
