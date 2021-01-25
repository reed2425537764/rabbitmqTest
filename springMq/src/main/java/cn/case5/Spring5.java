package cn.case5;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Author: shiyuqin
 * @Date: 2020/11/8 15:49
 */
public class Spring5 {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("rabbitmq-case5.xml");
        Send5 send5 = applicationContext.getBean(Send5.class);
        send5.fun();

        try {
            TimeUnit.MINUTES.sleep(1L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        applicationContext.close();
    }
}
