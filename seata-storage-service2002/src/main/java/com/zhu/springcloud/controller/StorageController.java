package com.zhu.springcloud.controller;

import com.zhu.springcloud.service.StorageService;
import com.zhu.springcloud.util.CommonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 描述:
 * 库存控制器
 *
 * @author zhuchong
 * @create 2020-04-14 16:30
 */
@RestController
public class StorageController {

    @Resource
    private StorageService storageService;

    /**
     * 扣减库存
     * @param productId
     * @param count
     * @return
     */
    @RequestMapping("/storage/decrease")
    public CommonResult decrease(Long productId, Integer count){
        storageService.decrease(productId,count);
        return new CommonResult(200,"扣减库存成功");
    }

}
