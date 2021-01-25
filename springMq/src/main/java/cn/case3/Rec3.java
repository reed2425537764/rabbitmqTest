package cn.case3;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Author: shiyuqin
 * @Date: 2020/11/7 15:22
 */
/*
* consumer ack机制
* 需设置 acknowledge="manual"
* */
@Component
public class Rec3 implements ChannelAwareMessageListener {
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        System.out.println(new String(message.getBody()));

        //第二个参数为true则ack前面所有消费的信息
        //channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);

        //入参 requeue为重回队列
        channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);

        TimeUnit.MINUTES.sleep(2L);
    }
}
