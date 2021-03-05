package com.ek.leetcode.bazinga.mq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * Copyright (C), 2019-2021
 * FileName: TryRocketMq
 * Author:   renyc
 * Date:     2021/3/3 4:35 下午
 * Description:
 * 使用RocketMQ有以下3种发送消息的方式,分别适用不同场景:
 * 1.同步发送消息:可靠的同步传输用于广泛的场景，如重要的通知消息，短信通知，短信营销系统等。
 * 2.异步发送消息:异步传输通常用于响应时间敏感的业务场景。
 * 3.以单向模式发送消息:单向传输用于需要中等可靠性的情况，例如日志收集。
 */
public class TryRocketMqProduce {
    public static void main(String[] args) throws Exception {
        //Instantiate with a producer group name.
        DefaultMQProducer producer = new
                DefaultMQProducer("please_rename_unique_group_name");
        // Specify name server addresses.
        producer.setNamesrvAddr("localhost:9876");
        //Launch the instance.
        producer.start();
        for (int i = 0; i < 100; i++) {
            //Create a message instance, specifying topic, tag and message body.
            Message msg = new Message("TopicTest" /* Topic */,
                    "TagA" /* Tag */,
                    ("Hello RocketMQ " +
                            i).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
            );
            //Call send message to deliver message to one of brokers.
            SendResult sendResult = producer.send(msg);
            System.out.printf("%s%n", sendResult);
        }
        //Shut down once the producer instance is not longer in use.
        producer.shutdown();
    }
}