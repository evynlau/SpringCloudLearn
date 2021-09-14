package com.liuwei.learn.stream.controller;

import com.liuwei.learn.stream.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author ：LiuWei
 * @Date ：Created in 2021/9/14 10:50
 * @Package: com.liuwei.learn.stream.controller
 * @Modified By：
 * @Description：
 */
@RestController
public class SendMessageController {

    @Resource
    private IMessageProvider messageProvider;

    @GetMapping("/send")
    public String sendMessage(){
        return messageProvider.send();
    }
}
