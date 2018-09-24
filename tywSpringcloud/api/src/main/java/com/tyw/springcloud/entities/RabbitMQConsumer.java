package com.tyw.springcloud.entities;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class RabbitMQConsumer {

    public static void main(String[] args) throws Exception{
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("118.25.49.121");
        factory.setPort(5672);
        factory.setUsername("tyw");
        factory.setPassword("tyw");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        //String queueName = channel.queueDeclare().getQueue();
        //channel.queueBind("test", "test_exchange", "topic.123");
        channel.basicQos(1);
        Consumer consumer = new DefaultConsumer(channel){
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [x1] Received '" + message + "'");
            }
        };
        channel.basicConsume("log.2", true, consumer);

    }

}
