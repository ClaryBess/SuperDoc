package com.example.test.mapper;

import com.example.test.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    /*
    查所有
    return List<Person>
     */
    List<User> getAll();

    /*
    根据ID查询
    {id} 要查询人员的 id
     */
    User getUserByID(int UserID);

    /*
    删除
    {id} 要删除人员的 id
     */
    void delete(int UserID);

    /*
    更新
    {p} 要更新的Person实例
     */
    void update(User p);

    /*
    增加
    {p} 要新增的Person实例
     */
    void newp(User p);
}
