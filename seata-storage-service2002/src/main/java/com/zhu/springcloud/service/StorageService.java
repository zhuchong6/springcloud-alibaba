package com.zhu.springcloud.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * @author zhuchong
 */
public interface StorageService {

    /**
     * 扣减库存
     * @param productId
     * @param count
     */
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
