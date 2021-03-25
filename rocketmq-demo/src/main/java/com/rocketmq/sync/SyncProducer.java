package com.rocketmq.sync;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;

/**
 * @author xiaomao
 * @version 1.0
 * @file com.rocketmq.sync.SyncProducer
 * @description
 * @date 2021/3/11 0011
 * //TODO
 */
public class SyncProducer {

    public static void main(String[] args) throws MQClientException,
            UnsupportedEncodingException,
            RemotingException, InterruptedException, MQBrokerException {

        // 实例化消息生产者Producer
        DefaultMQProducer producer = new DefaultMQProducer("SyncProducer");
        // 设置NameServer的地址
        producer.setNamesrvAddr("192.168.139.128:9876;192.168.139.129:9876");
        // 启动Producer实例
        producer.start();
        for (int i = 0; i < 5; i++) {
            // 创建消息，并指定Topic，Tag和消息体
            /*
            * topic
            * tag
            * body
            */
            Message msg = new Message("TopicTest", "TagA", ("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET) );
            // 发送消息到一个Broker
            SendResult sendResult = producer.send(msg);
            // 通过sendResult返回消息是否成功送达
            System.out.printf("%s%n", sendResult);
        }
        // 如果不再发送消息，关闭Producer实例。
        producer.shutdown();

    }

}
