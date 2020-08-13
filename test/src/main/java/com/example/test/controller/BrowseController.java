package com.example.test.controller;

import com.example.test.bean.Browse;
import com.example.test.service.BrowseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BrowseController {

    @Autowired
    BrowseService browseService;

    @GetMapping("/browse/{UserID}")
    public List<Browse> getBrowseByUser(@PathVariable("UserID") Integer UserID){
        return browseService.getBrowseByUser(UserID);
    }

    @GetMapping("/browse")
    public Browse insertBrowse(Browse browse){
        browseService.insertBrowse(browse);
        return browseService.getBrowseById(browse.getBrowseID());
    }

    @GetMapping("/browse/update/{BrowseID}")
    public Browse updateDateTime(@PathVariable("BrowseID") Integer BrowseID){
        browseService.updateDateTime(BrowseID);
        return browseService.getBrowseById(BrowseID);
    }
}
