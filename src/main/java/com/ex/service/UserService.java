package com.ex.service;

import com.ex.po.UserPo;

/**
 * Created by hanaijun on 2018/12/19
 */

public interface UserService {
    void addUser(UserPo userPo);

    void senMsg(String msg);
}
