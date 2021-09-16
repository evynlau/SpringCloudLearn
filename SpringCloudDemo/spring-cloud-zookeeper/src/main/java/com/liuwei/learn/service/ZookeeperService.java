package com.liuwei.learn.service;

import com.liuwei.learn.utils.ZKUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.CuratorZookeeperClient;
import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Author ：LiuWei
 * @Date ：Created in 2021/9/16 14:16
 * @Package: com.liuwei.learn.service
 * @Modified By：
 * @Description：
 */
@Service
@Slf4j
public class ZookeeperService {

    @Value("${zk.url}")
    private String zkUrl;

    @Value("${zk.timeout}")
    private int timeout = 1000;

    public String getClient() throws Exception {
        CuratorFramework client = ZKUtil.getClient(zkUrl,timeout);
        client.start();
        log.info("run CuratorFramework#start() successed !");

        CuratorZookeeperClient zookeeperClient = client.getZookeeperClient();
        log.info("run CuratorZookeeperClient#isConnected()  :{}",zookeeperClient.isConnected());
        ZooKeeper zk = zookeeperClient.getZooKeeper();

        String data = client.getData().toString();
        log.info("get zookeeper client :{}",data);

        client.close();
        log.info("run CuratorFramework#close() successed !");

        return data;
    }
}
