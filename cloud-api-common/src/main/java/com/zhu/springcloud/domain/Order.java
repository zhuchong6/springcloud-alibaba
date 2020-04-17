package com.zhu.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 描述:
 * 对应订单库的订单表
 *
 * @author zhuchong
 * @create 2020-04-11 11:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private Long id;
    private Long userId;
    private Long produceId;
    private Integer count;
    private BigDecimal money;
    /**
     * 订单状态 0-创建中 1-已完成
     */
    private Integer status;

}
