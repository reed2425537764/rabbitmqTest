package cn.case2;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @Author: shiyuqin
 * @Date: 2020/10/31 19:15
 */
//回退模式 return       exchange接收成功但路由到queue失败 会回调ReturnCallback
@Component
public class Send {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send() {
        //true为把路由到queue失败的消息返回给交换机进行回调ReturnCallback    false为把路由到queue失败的消息直接丢弃
        rabbitTemplate.setMandatory(true);

        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            //需要开启<rabbit:connection-factory publisher-returns="true"
            @Override
            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
                System.out.println("message = " + message);
                System.out.println("replyCode = " + replyCode);
                System.out.println("replyText = " + replyText);
                System.out.println("exchange = " + exchange);
                System.out.println("routingKey = " + routingKey);

                System.out.println("回调成功 im in producer");
            }
        });

        rabbitTemplate.convertAndSend("test.direct","key11", LocalDateTime.now().toString());
    }
}
