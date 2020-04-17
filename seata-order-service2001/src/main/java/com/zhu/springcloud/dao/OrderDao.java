package com.zhu.springcloud.dao;

import com.zhu.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 描述:
 * 订单接口
 *
 * @author zhuchong
 * @create 2020-04-11 12:33
 */
@Mapper
public interface OrderDao {
    /**
     * 新建订单
     * @param order
     */
    void create(Order order);

    /**
     * 修改订单状态 0->1
     * @param userId
     * @param status
     */
    void update(@Param("userId") Long userId, @Param("status") Integer status);

}
