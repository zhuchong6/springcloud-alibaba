package com.zhu.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 描述:
 * 账户实体类
 *
 * @author zhuchong
 * @create 2020-04-14 16:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private Long id;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 账户总额度
     */
    private BigDecimal total;
    /**
     * 账户已用额度
     */
    private BigDecimal used;
    /**
     * 账户剩余可用额度
     */
    private BigDecimal residue;
}
