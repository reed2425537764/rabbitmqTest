package cn.case1;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

import java.util.Arrays;

/**
 * @Author: shiyuqin
 * @Date: 2020/10/25 15:45
 */
public class Rec2 implements MessageListener {
    @Override
    public void onMessage(Message message) {
        System.out.println(new String(message.getBody()));
        System.out.println(message.getMessageProperties());
    }
}
