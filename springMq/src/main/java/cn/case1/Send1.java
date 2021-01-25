package cn.case1;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @Author: shiyuqin
 * @Date: 2020/10/25 13:34
 */
@Component
public class Send1 {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send() {
        rabbitTemplate.convertAndSend("test.direct","key1", LocalDateTime.now().toString());
        System.out.println("发送成功");
    }
}
