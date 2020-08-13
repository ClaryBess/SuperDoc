package com.example.test.mapper;

import com.example.test.bean.Comment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommentMapper {

    @Select("select * from Comment where CommentID=#{CommentID}")
    public Comment getCommentById(Integer CommentID);

    @Select("select * from Comment where DocID=#{DocID}")
    public List<Comment> getCommentByDoc(Integer DocID);

    @Select("select * from Comment where UserID=#{UserID}")
    public List<Comment> getCommentByUser(Integer UserID);

    @Options(useGeneratedKeys = true,keyProperty = "CommentID")
    @Insert("insert into Comment(DocID,UserID,Content) values(#{DocID},#{UserID},#{Content})")
    public int insertComment(Comment comment);

    @Delete("delete from Comment where CommentID=#{CommentID}")
    public int deleteById(Integer CommentID);

    @Delete("delete from Comment where DocID=#{DocID}")
    public int deleteByDoc(Integer DocID);

    @Delete("delete from Comment where UserID=#{UserID}")
    public int deleteByUser(Integer UserID);
}



