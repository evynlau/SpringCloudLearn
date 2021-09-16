package com.liuwei.learn.controller;

import com.liuwei.learn.service.ZookeeperService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author ：LiuWei
 * @Date ：Created in 2021/9/16 15:44
 * @Package: com.liuwei.learn.controller
 * @Modified By：
 * @Description：
 */
@Api(tags = "apache curator 使用学习")
@RestController
public class ZookeeperController {

    @Resource
    ZookeeperService service;

    @GetMapping("/getClient")
    public Object getClient() throws Exception {
        return service.getClient();
    }
}
