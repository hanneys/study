package com.ex.listener;

import com.ex.config.RabbitConfigure;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by hanaijun on 2018/12/19
 */
@Component
@Slf4j
public class UserListener {


    @RabbitListener(containerFactory = "rabbitListenerContainerFactory",
            bindings = @QueueBinding(
                    value = @Queue(value = RabbitConfigure.USER_QUENE, durable = "true", autoDelete="true"),
                    exchange = @Exchange(value = RabbitConfigure.USER_EXCHANGE, type = ExchangeTypes.TOPIC),
                    key = RabbitConfigure.USER_BIND_KEY)
    )
    public void receive(String msg){
        log.info("-------------->"+msg);
    }
}
