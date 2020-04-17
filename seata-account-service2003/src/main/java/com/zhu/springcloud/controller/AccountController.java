package com.zhu.springcloud.controller;

import com.zhu.springcloud.service.AccountService;
import com.zhu.springcloud.util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * 描述:
 * 账户控制器
 *
 * @author zhuchong
 * @create 2020-04-14 16:53
 */
@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

    /**
     * 扣减账户金钱
     * @param userId 账户id
     * @param money 扣减数量
     * @return
     */
    @RequestMapping("/account/decrease")
    public CommonResult  decrease(Long userId, BigDecimal money){
        accountService.decrease(userId, money);
        return new CommonResult(200, "账户扣减成功");
    }

}
