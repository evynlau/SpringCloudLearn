package com.liuwei.learn.lbrules;

import com.netflix.loadbalancer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author ：LiuWei
 * @Date ：Created in 2021/8/27 14:50
 * @Package: com.liuwei.learn.lbrules
 * @Modified By：
 * @Description：负载规则 轮询 随机 。。。。
 */
@Configuration
public class LoadbalancerRule {

    /**
     * 轮询负载均衡算法原理：请求次数 % 总服务数 = 实际调用服务的下标 。每次服务重启重置次数
     * allServers总服务数
     * nextServerCyclicCounter服务计数，AtomicInteger类型。默认初始值0
     * @see RoundRobinRule#choose(ILoadBalancer, Object)
     */
    @Bean
    public IRule rule(){
//        return new RetryRule();//先轮询，失败后在指定时间内重试
//        return new WeightedResponseTimeRule();//对轮询做响应速度的加权扩展，响应速度越快越容易被选中
//        return new BestAvailableRule();//先过滤掉断路状态下的服务，然后选择并发量小的服务
//        return new RoundRobinRule();//轮询
        return new RoundRobinRule();//轮询
//        return new RandomRule();//随机
//        return new AvailabilityFilteringRule();//先过滤掉故障实例，在选择并发量小的服务
//        return new ZoneAvoidanceRule();//复合判断server所在区域的性能和可用性，选择适当服务器
    }
}
