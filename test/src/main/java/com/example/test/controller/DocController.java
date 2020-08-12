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

    @GetMapping("/doc/update/c")
    public Document updateCon(Document document){
        documentMapper.updateCon(document);
        return document;
    }

    @GetMapping("/doc/update/p")
    public Document updatePri(Document document){
        documentMapper.updatePri(document);
        return document;
    }

    @GetMapping("/doc/update/r")
    public Document updateRec(Document document){
        documentMapper.updateRec(document);
        return document;
    }

    @GetMapping("/doc/update/t")
    public Document updateTea(Document document){
        documentMapper.updateTea(document);
        return document;
    }

    @GetMapping("/doc/comment/{DocID}")
    public Document comment(@PathVariable("DocID") Integer DocID){
        documentMapper.commentDoc(DocID);
        return documentMapper.getDocById(DocID);
    }

    @GetMapping("/doc/collect/{DocID}")
    public Document collect(@PathVariable("DocID") Integer DocID){
        documentMapper.collectDoc(DocID);
        return documentMapper.getDocById(DocID);
    }
}
