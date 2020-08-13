package com.example.test.service;

import com.example.test.bean.User;
import com.example.test.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    //将DAO注入Service层
    @Autowired
    UserMapper userMapper;

    /**
     * 注册
     * @param user
     * @return
     */

    public User Regis(User user){
        User user1 = userMapper.selectUserByName(user.getUserName());
        User user2 = userMapper.selectUserByEmail(user.getEmail());
        if(user1==null && user2==null){
            userMapper.insertUser(user);
            return user;
        }
        else
            return null;
    }

    /**
     * 登录验证
     * @param name
     * @param password
     * @return
     */
    @Override
    public User loginIn(String name, String password) {
        User user1 = userMapper.getInfo(name, password);
        if(user1 != null)
            return user1;
        else
            return null;
    }

    /**
     * 根据ID查询用户信息
     * @param id
     * @return
     */
    @Override
    public User queryUserById(Integer id) {
        User user = userMapper.selectUserById(id);
        if(user != null)
            return user;
        else
            return null;

    }

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    public User queryUserByName(String username){
        User user = userMapper.selectUserByName(username);
        if(user != null)
            return user;
        else
            return null;
    }

    /**
     * 根据邮箱查找用户
     * @param email
     * @return
     */
    public User queryUserByEmail(String email){
        User user = userMapper.selectUserByEmail(email);
        if(user != null)
            return user;
        else
            return null;
    }

    /**
     * 根据ID删除用户
     * @param id
     * @return
     */
    @Override
    public void dropUser(Integer id) {

        userMapper.deleteUser(id);

    }


    /**
     * 修改用户信息
     * remark：实际上还是根据用户ID修改用户信息
     * @param user
     * @return
     */
    @Override
    public void modifyUser(User user) {

        userMapper.updateUser(user);

    }

    /**
     * 根据ID退出用户
     * @param user
     * @return
     */
    @Override
    public void loginOut(User user){
        userMapper.exitUser(user);

    }
}
