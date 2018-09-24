package com.tyw.springcloud.entities;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class RabbitMQProducer {
    public static void main(String[] args) throws Exception{
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("118.25.49.121");
        factory.setPort(5672);
        factory.setUsername("tyw");
        factory.setPassword("tyw");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        //channel.exchangeDeclare("test_exchange", "fanout");
        //channel.exchangeDeclare("topic_exchange", "topic");
        channel.queueBind("log.1", "topic_exchange", "log.*");
        channel.queueBind("log.2", "topic_exchange", "log.a");
        channel.basicPublish("topic_exchange", "log.a", null, ("ceshi").getBytes());

        /*int i = 0;
        while (i < 10){
            i ++;
            channel.basicPublish("test_exchange", "", null, ("ceshi" + i).getBytes());
        }*/
        channel.close();
        connection.close();
    }
}
