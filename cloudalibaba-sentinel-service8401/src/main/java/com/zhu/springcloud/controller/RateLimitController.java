package com.zhu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zhu.springcloud.util.CommonResult;
import com.zhu.springcloud.myhandler.CustomerHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:
 * 按照资源名称限流
 *
 * @author zhuchong
 * @create 2020-04-07 2:41
 */
@RestController
@Slf4j
public class RateLimitController {
    /**
     * byResource流控
     * @return
     */
    @GetMapping(value = "/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult byResource(){
        return new CommonResult(200, "按照资源名称限流ok", "are u ok resource");
    }
    public CommonResult handleException(BlockException be){
        return new CommonResult(444, be.getClass().getCanonicalName()+"\t 服务不可用");
    }

    /**
     * byUrl流控
     * @return
     */
    @GetMapping(value = "/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl(){
        return new CommonResult(200, "按照URL名称限流ok", "are u ok url");
    }


    /**
     * 客户自定义，类封装
     * @return
     */
    @GetMapping(value = "/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerHandler.class,
            blockHandler = "customerBlockHandlerException2")
    public CommonResult customerBlockHandler(){
        return new CommonResult(200, "按照客户自定义处理", "are u ok url");
    }


    /**
     * byUrl流控
     * @return
     */
    @GetMapping(value = "/byUrl2")
    public CommonResult byUrl2(){
        return new CommonResult(200, "按照URL名称限流ok", "are u ok url");
    }


}
