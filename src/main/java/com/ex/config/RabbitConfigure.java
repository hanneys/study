package com.ex.config;

import org.springframework.context.annotation.Configuration;

/**
 * Created by hanaijun on 2018/12/19
 */
@Configuration
public class RabbitConfigure {

    /**
     *  队列名称
     */
    public final static String USER_QUENE = "user-quene-";
    /**
     * 交换机名称
     */
    public final static String USER_EXCHANGE = "user-exchange-";
    /**
     * 绑定的值
     */
    public static final String USER_BIND_KEY = "user-bind-key-";

}