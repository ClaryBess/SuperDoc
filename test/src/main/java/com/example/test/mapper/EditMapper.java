package com.example.test.mapper;

import com.example.test.bean.Edit;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface EditMapper {

    @Options(useGeneratedKeys = true,keyProperty = "EditID")
    @Insert("insert into Edit(DocID,UserID) values(#{DocID},#{UserID})")
    public int insertEdit(Edit edit);

    @Delete("delete from Edit where EditID=#{EditID}")
    public int deleteById(Integer EditID);

    @Delete("delete from Edit where DocID=#{DocID}")
    public int deleteByDoc(Integer DocID);

    @Delete("delete from Edit where UserID=#{UserID}")
    public int deleteByUser(Integer UserID);

    @Update("update Edit set DateTime=now() where EditID=#{EditID}")
    public int updateDateTime(Integer EditID);

    @Select("select * from Edit where EditID=#{EditID}")
    public Edit getEditById(Integer EditID);

    @Select("select * from Edit where DocID=#{DocID}")
    public List<Edit> getEditByDoc(Integer DocID);

    @Select("select * from Edit where UserID=#{UserID}")
    public List<Edit> getEditByUser(Integer UserID);

}
