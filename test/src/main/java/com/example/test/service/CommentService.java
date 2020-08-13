package com.example.test.service;

import com.example.test.bean.Comment;
import com.example.test.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentMapper commentMapper;

    //添加一条评论
    public Comment insertComment(Comment comment){
        commentMapper.insertComment(comment);
        return commentMapper.getCommentById(comment.getCommentID());
    }

    //删除一条评论
    public int deleteById(Integer CommentID){
        return commentMapper.deleteById(CommentID);
    }

    //删除文档所有评论
    public int deleteByDoc(Integer DocID){
        return commentMapper.deleteByDoc(DocID);
    }

    //删除用户所有评论
    public int deleteByUser(Integer UserID){
        return commentMapper.deleteByUser(UserID);
    }

    //查询某条评论
    public Comment getCommentById(Integer CommentID){
        return commentMapper.getCommentById(CommentID);
    }

    //文档所有评论
    public List<Comment> getCommentByDoc(Integer DocID){
        return commentMapper.getCommentByDoc(DocID);
    }

    //用户所有评论
    public List<Comment> getCommentByUser(Integer UserID){
        return commentMapper.getCommentByUser(UserID);
    }

}
