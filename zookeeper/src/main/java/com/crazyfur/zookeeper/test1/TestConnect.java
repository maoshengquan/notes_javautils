package com.crazyfur.zookeeper.test1;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;
import org.apache.zookeeper.data.Stat;
import org.apache.zookeeper.server.auth.DigestAuthenticationProvider;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author xiaomao
 * @version 1.0
 * @des 描述
 * @date 2021/8/7 0007
 * //TODO
 */
public class TestConnect {
    public static void main(String[] args) throws IOException, InterruptedException, KeeperException, NoSuchAlgorithmException {

        CountDownLatch countDownLatch = new CountDownLatch(1);

        // 1.创建zooKeeper连接
        ZooKeeper zooKeeper = new ZooKeeper("192.168.139.101:2181", 500, new Watcher() {
            public void process(WatchedEvent watchedEvent) {
                Event.KeeperState state = watchedEvent.getState();
                if (state == Event.KeeperState.SyncConnected){
                    System.out.println("connection success...");
                    countDownLatch.countDown();
                }
            }
        });

        countDownLatch.await();

        // acl(zooKeeper);
        // get(zooKeeper);
        // getservice(zooKeeper);
        zooKeeper.create("/testlisener/8081", "127.0.0.1:8081".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

        zooKeeper.close();
    }

    /**
     * 获取服务注册的服务地址
     * @param zooKeeper
     * @throws KeeperException
     * @throws InterruptedException
     */
    public static void getservice(ZooKeeper zooKeeper) throws KeeperException, InterruptedException {
        String path = "/mayikt";
        // 获取该节点下子集
        List<String> children = zooKeeper.getChildren(path, null, new Stat());
        for (int i = 0; i < children.size(); i++) {
            String pathChildren = path + "/" + children.get(i);
            byte[] data = zooKeeper.getData(pathChildren, null, new Stat());
            System.out.println("服务接口地址:" + new String(data));
        }
    }

    /**
     * 创建节点
     * @param zooKeeper
     */
    public static void create(ZooKeeper zooKeeper) throws KeeperException, InterruptedException {
        // 2.创建临时节点
        String s1 = zooKeeper.create("/mayikt", "mayikt".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        System.out.println("s1:" + s1);
        // 3.创建持久节点
        String s2 = zooKeeper.create("/mayikt", "mayikt".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println("s2:" + s2);
        // 4.创建持久节点带顺序
        String s3 = zooKeeper.create("/mayikt", "mayikt".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);
        System.out.println("s3:" + s3);
        // 5.创建临时节点带顺序
        String s4 = zooKeeper.create("/mayikt", "mayikt".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println("s4:" + s4);
    }


    /**
     * 1.给节点设置权限
     */
    public static void acl(ZooKeeper zooKeeper) throws KeeperException, InterruptedException, NoSuchAlgorithmException {
        // 2.创建账号权限 admin可以实现读写操作
        Id id1 = new Id("digest", DigestAuthenticationProvider.generateDigest("admin:admin"));
        ACL acl1 = new ACL(ZooDefs.Perms.ALL, id1);

        // 3.创建权限guest 只允许做读操作
        Id id2 = new Id("digest", DigestAuthenticationProvider.generateDigest("guest:guest"));
        ACL acl2 = new ACL(ZooDefs.Perms.READ, id2);
        // 4.添加该账号
        ArrayList<ACL> aces = new ArrayList<ACL>();
        aces.add(acl1);
        aces.add(acl2);
        // 5.创建该节点
        String s1 = zooKeeper.create("/memberservice", "mayikt".getBytes(), aces, CreateMode.PERSISTENT);
        System.out.println("s1:" + s1);
    }

    /**
     * 查询该节点必须授权账号
     */
    public static void get(ZooKeeper zooKeeper) throws KeeperException, InterruptedException {
        // 2.设置zk连接账号
        zooKeeper.addAuthInfo("digest", "guest:guest".getBytes());
        byte[] bytes = zooKeeper.getData("/memberservice", null, new Stat());
        String string = new String(bytes);
        System.out.println(string);
    }

}
