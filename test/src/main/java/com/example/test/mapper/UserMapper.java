package com.example.test.mapper;

import com.example.test.bean.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserMapper {

    //注册用户

    int Register(User user);

    //登录信息校对
    @Select("select * from User where UserName=#{name},Password=#{password}")
    User getInfo(String name, String password);

    //根据userid查询用户信息
    @Select("select * from User where UserID=#{id}")
    User selectUserById(Integer id);

    //根据用户名查找用户
    @Select("select * from User where UserName=#{username}")
    User selectUserByName(String username);

    //根据邮箱查找用户
    @Select("select * from User where UserEmail=#{email}")
    User selectUserByEmail(String email);

    //删除用户
    @Delete("delete from User where UserID=#{id}")
    void deleteUser(Integer id);

    //修改用户
    @Update("update User set UserName=#{UserName},Password=#{Password},Gender=#{Gender},Birthday=#{Birthday},ProfileUrl=#{ProfileUrl} where UserID=#{id}")
    void updateUser(User user);

    //用户退出
    void exitUser(User user);

    //加入用户
    @Insert("insert into User(UserName,Password,Email) values(#{name},#{password},#{email})")
    void insertUser(User user);
}
