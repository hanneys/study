package com.ex.controller;

import com.ex.po.UserPo;
import com.ex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hanaijun on 2018/12/19
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/addUser")
    public String addUser(UserPo userPo){
        userService.addUser(userPo);
        return "success";
    }

    @RequestMapping("/sendMsg")
    public String sendMsg(UserPo userPo){
        userService.senMsg(userPo.getName());
        return "success";
    }
}
