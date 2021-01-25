package cn.case4;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.TimeUnit;

/**
 * @Author: shiyuqin
 * @Date: 2020/11/7 19:23
 */
public class Spring4 {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext  = new ClassPathXmlApplicationContext("rabbitmq-case4.xml");

        try {
            TimeUnit.MINUTES.sleep(2L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        applicationContext.close();
    }
}
