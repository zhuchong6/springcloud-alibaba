package com.zhu.springcloud.service.impl;

import com.zhu.springcloud.dao.AccountDao;
import com.zhu.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * 描述:
 * 账户服务
 *
 * @author zhuchong
 * @create 2020-04-14 16:50
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("------->account-service账户扣减开始");

        try {//设置超时20s，测试分布式事务
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        accountDao.decrease(userId, money);
        log.info("------->account-service账户扣减结束");
    }
}
