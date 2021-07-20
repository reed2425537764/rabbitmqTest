package cn.case7;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @Author: shiyuqin
 * @Date: 2021/1/29 13:17
 */
@Component
public class Send7 {

    private static final Logger logger = LoggerFactory.getLogger(Send7.class);

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send() {
        String message = LocalDateTime.now().toString();
        amqpTemplate.convertAndSend(message);
        logger.info("send message :  {}", message);
    }
}
