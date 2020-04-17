package com.zhu.springcloud.exception;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zhu.springcloud.util.CommonResult;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 描述:
 * 专门处理sentinel相关的异常
 *
 * @author zhuchong
 * @create 2020-04-07 4:43
 */
public class SentinelExceptionHandler {

    public static CommonResult fallback(@PathVariable("id") Long id, BlockException e){
        return new CommonResult(500, "流量降级,入参是："+id+",异常是："+e.getMessage());
    }
}
