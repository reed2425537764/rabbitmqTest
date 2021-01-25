package cn.case2;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @Author: shiyuqin
 * @Date: 2020/10/31 17:47
 */
@Component
//确认模式 confirm      exchange会回调ConfirmCallback
public class Send2 {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send() {
        //如果需要confirm回调 需要开启<rabbit:connection-factory publisher-confirms="true"
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            /*
            * correlationData 相关配置信息
            * ack exchange是否成功收到消息
            * cause 失败原因
            * */
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                System.out.println("correlationData = " + correlationData);
                System.out.println("ack = " + ack);
                System.out.println("cause = " + cause);
                System.out.println("回调成功 im in producer");
            }
        });

        rabbitTemplate.convertAndSend("test.direct","key1"
                , LocalDateTime.now().toString(), new CorrelationData());
    }
}
