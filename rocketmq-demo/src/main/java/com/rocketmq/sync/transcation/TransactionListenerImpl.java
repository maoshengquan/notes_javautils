package com.rocketmq.sync.transcation;

import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;

/**
 * @author xiaomao
 * @version 1.0
 * @file com.rocketmq.sync.transcation.TransactionListenerImpl
 * @description
 * @date 2021/3/13 0013
 * //TODO
 */
public class TransactionListenerImpl implements TransactionListener {

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
}
