package com.example.test.controller;

import com.example.test.bean.Edit;
import com.example.test.service.EditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EditController {

    @Autowired
    EditService editService;

    @GetMapping("/edit/user/{UserID}")
    public List<Edit> getEditByUser(@PathVariable("UserID") Integer UserID){
        return editService.getEditByUser(UserID);
    }

    @GetMapping("/edit")
    public Edit insertEdit(Edit edit){
        return editService.insertEdit(edit);
    }

}
