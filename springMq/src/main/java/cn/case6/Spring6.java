package cn.case6;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.TimeUnit;

/**
 * @Author: shiyuqin
 * @Date: 2020/11/21 15:14
 */
public class Spring6 {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("rabbitmq-case6.xml");

        Send1 send1 = applicationContext.getBean(Send1.class);
        send1.fun();

        try {
            TimeUnit.MINUTES.sleep(1L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        applicationContext.close();
    }
}
