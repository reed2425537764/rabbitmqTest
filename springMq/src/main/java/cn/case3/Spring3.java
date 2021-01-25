package cn.case3;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: shiyuqin
 * @Date: 2020/11/7 15:20
 */
public class Spring3 {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext  = new ClassPathXmlApplicationContext("rabbitmq-case3.xml");


        applicationContext.close();
    }
}
