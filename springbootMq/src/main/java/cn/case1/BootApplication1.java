package cn.case1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * @Author: shiyuqin
 * @Date: 2020/10/25 18:51
 */
@SpringBootApplication
public class BootApplication1 {

    private static final Logger logger = LoggerFactory.getLogger(BootApplication1.class);

    public static void main(String[] args) {
        logger.debug("rabbitMqTest with springboot starting at {}", LocalDateTime.now());
        SpringApplication springApplication = new SpringApplication(BootApplication1.class);
        ConfigurableApplicationContext applicationContext = springApplication.run(args);

        Send bean = applicationContext.getBean(Send.class);
        for (int i = 0; i < 10; i++) {

            bean.fun();
        }

        try {
            TimeUnit.MINUTES.sleep(1L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        applicationContext.close();
    }
}
