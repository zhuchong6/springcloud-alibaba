package com.zhu.springcloud.service;

import com.zhu.springcloud.domain.Order;
import org.apache.ibatis.annotations.Param;

/**
 * @author zhuchong
 */
public interface OrderService {

    /**
     * 新建订单，包含4步操作：
     * <p>1.本地新建订单</p>
     * <p>2.远程调用库存服务的扣减接口  storageService.decrease</p>
     * <p>3.远程调用账户服务的扣减接口  accountService.decrease</p>
     * <p>4.本地修改订单状态，从0->1，1代表订单已完成</p>
     * @param order 见cloud-api-common:com.zhu.springcloud.domain.Order
     */
    void create(Order order);

    /**
     * 修改订单状态 0->1
     * @param userId
     * @param status
     */
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
