package com.liuwei.learn.stream.service.impl;

import cn.hutool.core.util.IdUtil;
import com.liuwei.learn.stream.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

/**
 * @Author ：LiuWei
 * @Date ：Created in 2021/9/14 10:37
 * @Package: com.liuwei.learn.stream.service.impl
 * @Modified By：
 * @Description：
 */
@EnableBinding(Source.class)
public class IMessageProvierImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        boolean flag = output.send(MessageBuilder.withPayload(IdUtil.randomUUID()).build());
        return String.format("IMessageProvierImpl#send()  flag:{}",flag);
    }

}
