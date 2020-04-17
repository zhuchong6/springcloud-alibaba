package com.zhu.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zhu.springcloud.util.CommonResult;

/**
 * 描述:
 * 用于sentinel的一些流控异常处理
 *
 * @author zhuchong
 * @create 2020-04-07 2:59
 */
public class CustomerHandler {

    public static  CommonResult customerBlockHandlerException(BlockException be){
        return  new CommonResult(4444, "用户自己定义的global handlerException----1");
    }

    public static  CommonResult customerBlockHandlerException2(BlockException be){
        return  new CommonResult(4444, "用户自己定义的global handlerException-----2");
    }

}
