package com.ex.service.impl;

import com.ex.config.RabbitConfigure;
import com.ex.domain.User;
import com.ex.po.UserPo;
import com.ex.service.UserService;
import com.ex.utils.IdGen;
import org.modelmapper.ModelMapper;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Created by hanaijun on 2018/12/19
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private ModelMapper modelMapper;


    @Autowired
    private AmqpTemplate amqpTemplate;


    private final IdGen idGen = IdGen.get();


    @Override
    public void addUser(UserPo userPo){
        User user=modelMapper.map(userPo,User.class);
        user.setId(idGen.nextId());
        user.setCreateTime(LocalDateTime.now());
        mongoTemplate.insert(user);
    }


    @Override
    public void senMsg(String msg){
        amqpTemplate.convertAndSend(RabbitConfigure.USER_EXCHANGE,RabbitConfigure.USER_BIND_KEY,msg);
    }
}
