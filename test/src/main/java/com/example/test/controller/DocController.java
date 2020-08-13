package com.example.test.controller;

import com.example.test.bean.Document;
import com.example.test.mapper.DocumentMapper;
import com.example.test.service.DocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DocController {

    @Autowired
    DocumentMapper documentMapper;
    @Autowired
    DocService docService;

    @GetMapping("/doc/{DocID}")
    public Document getDoc(@PathVariable("DocID") Integer DocID){
        return documentMapper.getDocById(DocID);
    }

    @GetMapping("/doc/user/{UserID}")
    public List<Document> getDocByUser(@PathVariable("UserID") Integer UserID){
        return docService.getDocByUser(UserID);
    }

    @GetMapping("/doc")
    public Document insertDoc(Document document){
        return docService.insertDoc(document);
    }

    @GetMapping("/doc/update/c")
    public Document updateCon(Document document){
        documentMapper.updateCon(document);
        return document;
    }

    @GetMapping("/doc/update/p/{userID}")
    public Document updatePri(Document document, @PathVariable("userID") Integer userID){
        docService.updatePri(document,userID);
        return docService.getDocById(document.getDocID());
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

    @GetMapping("/doc/update/e")
    public Document updateEdi(Document document){
        documentMapper.updateEdi(document);
        return docService.getDocById(document.getDocID());
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
