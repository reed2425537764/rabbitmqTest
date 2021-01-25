package cn.case1;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: shiyuqin
 * @Date: 2020/10/25 19:25
 */
@Component
public class Rec {

    //@RabbitListener(queues = {"queue1"})
    public void listener(Message message) {
        System.out.println(new String(message.getBody()));

    }
}
