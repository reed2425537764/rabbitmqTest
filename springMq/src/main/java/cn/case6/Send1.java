package cn.case6;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @Author: shiyuqin
 * @Date: 2020/11/21 16:07
 */
/*
* 消息成为死信有三种途径
* 1.消息过期
* 2.超过队列长度
* 3.消费端拒绝
*
* */
@Component
public class Send1 {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void fun() {
        rabbitTemplate.convertAndSend("test.direct","", LocalDateTime.now().toString());
        rabbitTemplate.convertAndSend("test.direct","", LocalDateTime.now().toString());
        rabbitTemplate.convertAndSend("test.direct","", LocalDateTime.now().toString());
    }
}
