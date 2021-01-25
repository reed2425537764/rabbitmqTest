package cn.case1;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.TimeUnit;

/**
 * @Author: shiyuqin
 * @Date: 2020/10/25 13:38
 */
public class Spring1 {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("rabbitmq-producer.xml");
        //生产者
        Send1 send1 = applicationContext.getBean(Send1.class);
        send1.send();

        try {
            TimeUnit.SECONDS.sleep(1L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        applicationContext.close();
    }
}
