package com.ek.leetcode.bazinga.utils.mq.two;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

public class Worker {

    private static final String QUEUE_NAME = "task_queue";

    public static void main(String[] args) throws Exception {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.1.107");
        factory.setPort(5672);
        factory.setUsername("snakeek");
        factory.setPassword("Passw0rd");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C.");

        channel.basicQos(1);

        QueueingConsumer consumer = new QueueingConsumer(channel);
        channel.basicConsume(QUEUE_NAME, false, consumer);

        while (true) {

            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());

            System.out.println(" [x] Received '" + message + "'");
            doWork(message);
            System.out.println(" [x] Done");

            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        }
    }

    private static void doWork(String task) throws Exception {

        for (char ch : task.toCharArray()) {
            if (ch == '.')
                Thread.sleep(1000);
        }
    }
}