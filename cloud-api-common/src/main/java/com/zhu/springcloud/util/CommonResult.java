package com.zhu.springcloud.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述:
 * 通用返回类包装类
 *
 * @author zhuchong
 * @create 2020-04-07 2:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {  //泛型：如果装的payment 返回payment,装的order 返回order

    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code,String message){
        this(code,message,null);
    }

}
