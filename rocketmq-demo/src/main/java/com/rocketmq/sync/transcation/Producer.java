package com.rocketmq.sync.transcation;

import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.TimeUnit;

/**
 * @author xiaomao
 * @version 1.0
 * @file com.rocketmq.sync.transcation.Producer
 * @description
 * @date 2021/3/13 0013
 * //TODO
 */
public class Producer {

    public static void main(String[] args) throws MQClientException, InterruptedException, IOException {
        // 创建事务监听器
//        TransactionListener transactionListener = new TransactionListenerImpl();
        // 创建消息生产者
        TransactionMQProducer producer = new TransactionMQProducer("group6");
        producer.setNamesrvAddr("192.168.139.128:9876;192.168.139.129:9876");

        // 生产者这是监听器
        producer.setTransactionListener(new TransactionListener() {
            @Override
            public LocalTransactionState executeLocalTransaction(Message msg, Object arg) {
                System.out.println("执行本地事务");
                if (StringUtils.equals("TagA", msg.getTags())) {
                    System.out.println("commit");
                    return LocalTransactionState.COMMIT_MESSAGE;
                } else if (StringUtils.equals("TagB", msg.getTags())) {
                    System.out.println("rollback");
                    return LocalTransactionState.ROLLBACK_MESSAGE;
                } else {
                    System.out.println("un know");
                    return LocalTransactionState.UNKNOW;
                }

            }

            @Override
            public LocalTransactionState checkLocalTransaction(MessageExt msg) {
                System.out.println("MQ检查消息Tag【"+msg.getTags()+"】的本地事务执行结果");
                return LocalTransactionState.COMMIT_MESSAGE;
            }
        });

        // 启动消息生产者
        producer.start();
        String[] tags = new String[]{"TagA", "TagB", "TagC"};
        for (int i = 0; i < 3; i++) {
            Message msg = new Message("TransactionTopic", tags[i % tags.length], "KEY" + i, ("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            SendResult sendResult = producer.sendMessageInTransaction(msg, null);
            System.out.printf("%s%n", sendResult);
            TimeUnit.SECONDS.sleep(1);
        }


//        System.in.read();
//        producer.shutdown();
    }

}
