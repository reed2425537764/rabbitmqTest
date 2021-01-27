package cn.case4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * @Author: shiyuqin
 * @Date: 2020/11/7 19:23
 */
public class Spring4 {

    private static final Logger logger = LoggerFactory.getLogger(Spring4.class);

    public static void main(String[] args) {
        logger.debug("rabbitMqTest with spring starting at {}", LocalDateTime.now());
        ConfigurableApplicationContext applicationContext  = new ClassPathXmlApplicationContext("rabbitmq-case4.xml");

        try {
            TimeUnit.MINUTES.sleep(2L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        applicationContext.close();
    }
}
