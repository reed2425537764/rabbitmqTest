package cn.case4;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Author: shiyuqin
 * @Date: 2020/11/7 19:24
 */
/*
* consumer 限流机制
* 配置 prefetch="1" 必须开启确认模式(手动ack)
* prefetch=1 表示consumer每次只会拉取一条信息 知道被确认消费完后 才会拉取下面一条
* */
@Component
public class Rec4 implements ChannelAwareMessageListener {
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        System.out.println(new String(message.getBody()));
        TimeUnit.MINUTES.sleep(1L);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }
}
