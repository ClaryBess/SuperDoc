package com.example.test.service;

import com.example.test.bean.Edit;
import com.example.test.mapper.EditMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditService {

    @Autowired
    EditMapper editMapper;

    //添加编辑记录
    public Edit insertEdit(Edit edit){
        editMapper.insertEdit(edit);
        return editMapper.getEditById(edit.getEditID());
    }

    //删除一条编辑记录
    public int deleteById(Integer EditID){
        return editMapper.deleteById(EditID);
    }

    //删除用户的编辑记录
    public int deleteByUser(Integer UserID){
        return editMapper.deleteByUser(UserID);
    }

    //删除文档的编辑记录
    public int deleteByDoc(Integer DocID){
        return editMapper.deleteByDoc(DocID);
    }

    //查询编辑记录
    public Edit getEditById(Integer EditID){
        return editMapper.getEditById(EditID);
    }

    //查询用户的编辑记录
    public List<Edit> getEditByUser(Integer UserID){
        return editMapper.getEditByUser(UserID);
    }

    //查询文档的编辑记录
    public List<Edit> getEditByDoc(Integer DocID){
        return editMapper.getEditByDoc(DocID);
    }

}
