package com.example.test.controller;

import com.example.test.bean.Document;
import com.example.test.mapper.DocumentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DocController {

    @Autowired
    DocumentMapper documentMapper;

    @GetMapping("/doc/{DocID}")
    public Document getDoc(@PathVariable("DocID") Integer DocID){
        return documentMapper.getDocById(DocID);
    }

    @GetMapping("/doc")
    public Document insertDoc(Document document){
        documentMapper.insertDoc(document);
        return document;
    }

}
