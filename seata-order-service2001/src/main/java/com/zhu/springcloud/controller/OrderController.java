package com.zhu.springcloud.controller;

import com.zhu.springcloud.domain.Order;
import com.zhu.springcloud.service.OrderService;
import com.zhu.springcloud.util.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 描述:
 * 订单控制器
 *
 * @author zhuchong
 * @create 2020-04-11 13:16
 */
@RestController
@Slf4j
public class OrderController {
    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult creat(Order order){
        orderService.create(order);
        return new CommonResult(200, "订单创建成功");
    }

}
