package com.crazyfur.zookeeper.test2;

import org.I0Itec.zkclient.ZkClient;

/**
 * @author xiaomao
 * @version 1.0
 * @des 描述
 * @date 2021/8/7 0007
 * //TODO
 */
public class TestCluster {

    //参数1 连接地址
    private static final String ADDRES = "192.168.139.101:2181,192.168.139.101:2182,192.168.139.101:2183";
    // 参数2 zk超时时间
    private static final int TIMEOUT = 5000;

    public static void main(String[] args) {
        ZkClient zkClient = new ZkClient(ADDRES, TIMEOUT);
        String path = "/testcluster";
        zkClient.createPersistent(path);
        zkClient.close();
    }

}
