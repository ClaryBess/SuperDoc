package com.example.test.service;

import com.example.test.bean.User;

public interface UserService {

    //注册
    User Regis(User user);

    //登录校验信息
    User loginIn(String name, String password);

    //根据用户id查找用户
    User queryUserById(Integer id);

    //根据用户名查找用户
    User queryUserByName(String username);

    //根据邮箱查找用户
    User queryUserByEmail(String email);

    //删除用户
    void dropUser(Integer id);

    //修改用户
    void modifyUser(User user);

    //用户退出
    void loginOut(User user);

}
