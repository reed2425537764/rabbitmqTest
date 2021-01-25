package cn.case2;

import cn.case1.Send1;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.TimeUnit;

/**
 * @Author: shiyuqin
 * @Date: 2020/10/31 17:47
 */
public class Spring2 {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("rabbitmq-case2.xml");

        /*Send2 send2 = applicationContext.getBean(Send2.class);
        send2.send();*/
        Send send = applicationContext.getBean(Send.class);
        send.send();

        try {
            TimeUnit.SECONDS.sleep(1L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        applicationContext.close();
    }
}
