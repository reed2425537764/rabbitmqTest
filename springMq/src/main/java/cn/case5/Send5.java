package cn.case5;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @Author: shiyuqin
 * @Date: 2020/11/8 15:57
 */
/*
 * TTL  两种方式
 * 方法一. 设置队列的过期时间 <entry key="x-message-ttl" value="10000" value-type="java.lang.Integer"/>
 *          队列过期后 清空队列中的消息
 * 方法二. 设置消息的过期时间  如下
            消息过期后只有在队列顶端(要被消费时)，才会判断是否过期(移除消息)， 以提高效率
 * */
@Component
public class Send5{
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void fun() {

        MessagePostProcessor messagePostProcessor = new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                message.getMessageProperties().setExpiration("10000");
                return message;
            }
        };

        rabbitTemplate.convertAndSend("test.direct","key3", LocalDateTime.now().toString(), messagePostProcessor);
    }
}
