package com.example.test.controller;

import com.example.test.bean.Collect;
import com.example.test.mapper.CollectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CollectController {

    @Autowired
    CollectMapper collectMapper;

    @GetMapping("/collect/{UserID}")
    public List<Collect> getCollectByUser(@PathVariable("UserID") Integer UserID){
        return collectMapper.getCollectByUser(UserID);
    }


}
