package com.zhu.springcloud.service.impl;

import com.zhu.springcloud.dao.OrderDao;
import com.zhu.springcloud.domain.Order;
import com.zhu.springcloud.service.AccountService;
import com.zhu.springcloud.service.OrderService;
import com.zhu.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 描述:
 * 订单服务
 *
 * @author zhuchong
 * @create 2020-04-11 12:52
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;
    @Resource
    private AccountService accountService;
    @Resource
    private StorageService storageService;


    @Override
    @GlobalTransactional(name="order-create", rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("1----->新建订单");
        //1.新建订单
        orderDao.create(order);

        log.info("2----->订单微服务调用库存，做扣减Count");
        //2.扣库存
        storageService.decrease(order.getProduceId(), order.getCount());
        log.info("2----->订单微服务调用库存，做扣减操作end");

        log.info("3----->订单微服务调用账户，做扣减操作Money");
        //3.扣钱
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("3----->订单微服务调用账户，做扣减操作end");

        log.info("4----->修改订单状态开始");
        //4.修改订单状态
        orderDao.update(order.getUserId(), 0);
        log.info("4----->修改订单状态结束");

        log.info("下订单操作结束了！！！！");

    }

    @Override
    public void update(Long userId, Integer status) {

    }
}
