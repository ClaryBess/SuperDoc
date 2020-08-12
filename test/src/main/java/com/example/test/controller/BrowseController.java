package com.example.test.controller;

import com.example.test.bean.Browse;
import com.example.test.mapper.BrowseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BrowseController {

    @Autowired
    BrowseMapper browseMapper;

    @GetMapping("/browse/{UserID}")
    public List<Browse> getBrowseByUser(@PathVariable("UserID") Integer UserID){
        return browseMapper.getBrowseByUser(UserID);
    }

    @GetMapping("/browse")
    public Browse insertBrowse(Browse browse){
        browseMapper.insertBrowse(browse);
        return browse;
    }

    @GetMapping("/browse/update/{BrowseID}")
    public Browse updateDateTime(@PathVariable("BrowseID") Integer BrowseID){
        browseMapper.updateDateTime(BrowseID);
        return browseMapper.getBrowseById(BrowseID);
    }
}
