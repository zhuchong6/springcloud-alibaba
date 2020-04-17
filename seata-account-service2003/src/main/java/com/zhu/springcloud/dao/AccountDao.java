package com.zhu.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author zhuchong
 */
@Mapper
public interface AccountDao {
    /**
     * 扣减账户金钱
     * @param userId 用户id
     * @param money 扣减数量
     */
    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
