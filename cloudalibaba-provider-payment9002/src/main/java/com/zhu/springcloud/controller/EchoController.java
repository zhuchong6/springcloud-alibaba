package com.zhu.springcloud.controller;

import cn.hutool.core.util.IdUtil;
import com.zhu.springcloud.util.CommonResult;
import com.zhu.springcloud.domain.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述:
 * nacos测试
 *
 * @author zhuchong
 * @create 2020-04-05 9:05
 */
@RestController
public class EchoController {

    @Value("${server.port}")
    private String serverPort;

    public static Map<Long, Payment> hashMap = new HashMap<>();
    static {
        hashMap.put(1L, new Payment(1L, IdUtil.fastSimpleUUID()));
        hashMap.put(2L, new Payment(2L, IdUtil.fastSimpleUUID()));
        hashMap.put(3L, new Payment(3L, IdUtil.fastSimpleUUID()));
        hashMap.put(4L, new Payment(4L, IdUtil.fastSimpleUUID()));
        hashMap.put(5L, new Payment(5L, IdUtil.fastSimpleUUID()));
    }


    @GetMapping(value = "/echo/{string}")
    public String echo(@PathVariable String string) {
        return "Hello Nacos Discovery " + string+"  port:"+serverPort;
    }

    @GetMapping(value = "/paymentSql/{id}")
    public CommonResult paymentSql(@PathVariable("id") Long id) {
        //模拟数据库操作
        Payment payment = hashMap.get(id);
        return new CommonResult(200, "from mysql ,serverPort: "+serverPort, payment);
    }

}
