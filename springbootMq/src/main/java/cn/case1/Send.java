package cn.case1;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @Author: shiyuqin
 * @Date: 2020/10/25 18:50
 */
@Component
public class Send {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void fun() {
        amqpTemplate.convertAndSend("test.direct", "key1", LocalDateTime.now().toString());
    }
}
