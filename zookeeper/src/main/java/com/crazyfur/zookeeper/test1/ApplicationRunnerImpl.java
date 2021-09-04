package com.crazyfur.zookeeper.test1;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

/**
 * @author xiaomao
 * @version 1.0
 * @des 描述
 * @date 2021/8/7 0007
 * //TODO
 */
@Component
public class ApplicationRunnerImpl implements ApplicationRunner {

    @Value("${server.port}")
    private String serverPort;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // start();
        lisener();
    }

    /**
     * 事件通知
     */
    public void lisener(){
        ZkClient zkClient = new ZkClient("192.168.139.101:2181", 5000);
        String path = "/testlisener";

        zkClient.subscribeChildChanges(path, new IZkChildListener() {
            @Override
            public void handleChildChange(String s, List<String> list) throws Exception {
                System.out.println(s + "节点发生了变化,剩余一下节点");
                list.forEach((t) -> System.out.println(t));
            }
        });

        zkClient.subscribeDataChanges(path+"/8080", new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {
                System.out.println(s + "节点内容发生了变化:" + o);
            }

            @Override
            public void handleDataDeleted(String s) throws Exception {
                System.out.println(s + "节点被移除~~~");
            }
        });
    }

    /**
     * 服务注册
     * @throws IOException
     * @throws KeeperException
     * @throws InterruptedException
     */
    public void start() throws IOException, KeeperException, InterruptedException {
        ZooKeeper zooKeeper = new ZooKeeper("192.168.139.101:2181", 50000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println(watchedEvent.getState().name());
            }
        });
        String parentPath = "/mayikt";
        Stat exists = zooKeeper.exists(parentPath, new Watcher() {
            @Override
            public void process(WatchedEvent event) {

            }
        });
        // 如果当前父节点不存在的情况 就创建
        if (exists == null) {
            zooKeeper.create(parentPath, "mayikt".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }
        // 将当前服务信息注册到zk上
        String data = "http://127.0.0.1:" + serverPort;
        zooKeeper.create(parentPath + "/" + serverPort, data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
    }
}
