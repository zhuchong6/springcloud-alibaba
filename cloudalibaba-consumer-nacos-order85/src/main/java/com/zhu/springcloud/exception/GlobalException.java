package com.zhu.springcloud.exception;

import com.zhu.springcloud.util.CommonResult;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 描述:
 * 通用异常处理
 *
 * @author zhuchong
 * @create 2020-04-07 4:20
 */
public class GlobalException {

    public static CommonResult exception1(@PathVariable("id") Long id, Throwable e){
        if(e instanceof IllegalArgumentException ){
            return new CommonResult(500, "参数异常,入参是："+id);
        } else if(e instanceof NullPointerException){
            return new CommonResult(500, "控制针对异常,入参是："+id);
        }else{
            return new CommonResult(500, "内部错误,入参是："+id);
        }

    }


}
