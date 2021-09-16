package com.liuwei.learn.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

import java.util.List;

/**
 * @Author ：LiuWei
 * @Date ：Created in 2021/9/16 14:47
 * @Package: com.liuwei.learn.utils
 * @Modified By：
 * @Description：
 */
@Slf4j
public class ZKUtil {

    /**
     * 获取客户端
     *
     * @param url
     * @param timeout
     * @return
     */
    public static CuratorFramework getClient(String url, int timeout) {
        /**
         * Curator 四种重连策略
         *
         * 1.RetryUntilElapsed(int maxElapsedTimeMs, int sleepMsBetweenRetries)
         *   以sleepMsBetweenRetries的间隔重连,直到超过maxElapsedTimeMs的时间设置
         *
         * 2.RetryNTimes(int n, int sleepMsBetweenRetries)
         *   指定重连次数
         *
         * 3.RetryOneTime(int sleepMsBetweenRetry)
         *   重连一次,简单粗暴
         *
         * 4.ExponentialBackoffRetry
         *   ExponentialBackoffRetry(int baseSleepTimeMs, int maxRetries)
         *   ExponentialBackoffRetry(int baseSleepTimeMs, int maxRetries, int maxSleepMs)
         *   时间间隔 = baseSleepTimeMs * Math.max(1, random.nextInt(1 << (retryCount + 1)))
         *
         */
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(timeout, 3);
//        return CuratorFrameworkFactory.newClient(url, retryPolicy);
        return CuratorFrameworkFactory.builder()
                .connectString(url)
                .sessionTimeoutMs(60 * 1000) //会话超时时间，默认60秒.
                .connectionTimeoutMs(15 * 1000) //连接超时时间，默认15秒
                .retryPolicy(retryPolicy)
                .build();
    }

    public static void create(final CuratorFramework client, final String path, final byte[] payload) throws Exception {
        client.create().creatingParentsIfNeeded().forPath(path, payload);
    }

    public static void createEphemeral(final CuratorFramework client, final String path, final byte[] payload) throws Exception {
        /**
         * zookeeper中节点有两种类型，临时节点和永久节点，CreateMode类用于指定创建节点的类型，用户可以选择以下几个参数：
         *
         * CreateMode.PERSISTENT: 创建节点后，不删除就永久存在
         * CreateMode.PERSISTENT_SEQUENTIAL：节点path末尾会追加一个10位数的单调递增的序列
         * CreateMode.EPHEMERAL：创建后，回话结束节点会自动删除
         * CreateMode.EPHEMERAL_SEQUENTIAL：节点path末尾会追加一个10位数的单调递增的序列
         * CreateMode.CONTAINER：这是个特殊的容器节点，可用于recipes中的leader、lock等，在子节点被删除后将成为候选节点
         * CreateMode.PERSISTENT_WITH_TTL：带生存时间。创建后，回话结束节点不会自动删除，但在指定的TTL生存时间内未作修改将被删除
         * CreateMode.PERSISTENT_SEQUENTIAL_WITH_TTL：带生存时间。节点path末尾会追加一个10位数的单调递增的序列
         */
        client.create().withMode(CreateMode.EPHEMERAL).forPath(path, payload);
    }


    public static String createEphemeralSequential(final CuratorFramework client, final String path, final byte[] payload) throws Exception {
        return client.create().withProtection().withMode(CreateMode.EPHEMERAL_SEQUENTIAL).forPath(path, payload);
    }


    public static void setData(final CuratorFramework client, final String path, final byte[] payload) throws Exception {
        client.setData().forPath(path, payload);
    }


    public static void delete(final CuratorFramework client, final String path) throws Exception {
        client.delete().deletingChildrenIfNeeded().forPath(path);
    }


    public static void guaranteedDelete(final CuratorFramework client, final String path) throws Exception {
        client.delete().guaranteed().forPath(path);
    }


    public static String getData(final CuratorFramework client, final String path) throws Exception {
        return new String(client.getData().forPath(path));
    }


    public static List<String> getChildren(final CuratorFramework client, final String path) throws Exception {
        return client.getChildren().forPath(path);
    }

}
