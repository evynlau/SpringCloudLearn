package com.liuwei.learn.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ：LiuWei
 * @Date ：Created in 2021/9/2 17:43
 * @Package: com.liuwei.learn.config.controller
 * @Modified By：
 * @Description：
 */
@RestController
public class ConfigController {
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return configInfo;
    }
}
