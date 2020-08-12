package com.example.test.mapper;

import com.example.test.bean.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Select("select * from User where UserID=#{UserID}")
    public User getUserById(Integer UserID);

    @Select("select * from User where UserName=#{UserName}")
    public User getUserByName(String UserName);

    @Select("select * from User where Email=#{Email}")
    public User getUserByEmail(String Email);

    @Delete("delete from User where UserID=#{UserID}")
    public int deleteUserById(Integer UserID);

    @Options(useGeneratedKeys = true,keyProperty = "UserID")
    @Insert("insert into User(UserName,Password,Email,Gender,Birthday,ProfileUrl) values(#{UserName},#{Password},#{Email},#{Gender},#{Birthday},#{ProfileUrl})")
    public int insertUser(User user);

    @Update("update User set Password=#{Password} where UserID=#{UserID}")
    public int updatePwd(User user);

    @Update("update User set Gender=#{Gender} where UserID=#{UserID}")
    public int updateGen(User user);

    @Update("update User set Birthday=#{Birthday} where UserID=#{UserID}")
    public int updateBir(User user);

    @Update("update User set ProfileUrl=#{ProfileUrl} where UserID=#{UserID}")
    public int updatePro(User user);
}
