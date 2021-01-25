package cn.case1;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @Author: shiyuqin
 * @Date: 2020/10/25 18:38
 */
@SpringBootConfiguration
public class MqConfig {

    @Bean
    public Exchange exchange() {
        return ExchangeBuilder.directExchange("test.direct").durable(false).build();
    }

    @Bean("queue1")
    public Queue queue1() {
        return QueueBuilder.nonDurable("queue1").build();
    }

    @Bean("queue2")
    public Queue queue2() {
        return QueueBuilder.nonDurable("queue2").build();
    }

    @Bean
    public Binding binding1(@Qualifier("queue1") Queue queue1, Exchange exchange) {
        return BindingBuilder.bind(queue1).to(exchange).with("key1")
                .noargs();
    }

    @Bean
    public Binding binding2(@Qualifier("queue2") Queue queue2, Exchange exchange) {
        return BindingBuilder.bind(queue2).to(exchange).with("key2")
                .noargs();
    }
}
