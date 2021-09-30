package com.liuwei.learn.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ：LiuWei
 * @Date ：Created in 2021/9/2 17:43
 * @Package: com.liuwei.learn.config.controller
 * @Modified By:
 * @Description:
 */
@RestController
@RefreshScope //curl -X POST "http://localhost:8889/actuator/refresh" 通过命令调用监控的refresh进行刷新
public class ConfigController {
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return configInfo;
    }
}
