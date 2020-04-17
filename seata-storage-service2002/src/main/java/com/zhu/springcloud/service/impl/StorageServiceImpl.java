package com.zhu.springcloud.service.impl;

import com.zhu.springcloud.dao.StorageDao;
import com.zhu.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 描述:
 * 库存服务
 *
 * @author zhuchong
 * @create 2020-04-14 16:27
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {
    @Resource
    private StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("---------》storage-service扣减库存开始");
        storageDao.decrease(productId,count);
        log.info("---------》storage-service扣减库存结束");
    }
}
