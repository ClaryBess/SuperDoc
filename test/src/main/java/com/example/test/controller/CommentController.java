package com.example.test.controller;

import com.example.test.bean.Comment;
import com.example.test.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping("/comment")
    public Comment insertComment(Comment comment){
        return commentService.insertComment(comment);
    }

}
