package com.example.test.mapper;

import com.example.test.bean.Document;
import org.apache.ibatis.annotations.*;

import java.util.List;

//指定这是一个操作数据库的mapper
@Mapper
public interface DocumentMapper {

    @Select("select * from Document where DocID=#{DocID}")
    public Document getDocById(Integer DocID);

    @Select("select * from Document where UserID=#{UserID}")
    public List<Document> getDocByUser(Integer UserID);

    @Delete("delete from Document where DocID=#{DocID}")
    public int deleteDocById(Integer DocID);

    @Insert("insert into Document(UserID,Title,Content,Privilege,IsTeam,Team,RecycleDateTime) values(#{UserID},#{Title},#{Content},#{Privilege},#{IsTeam},#{Team},#{RecycleDateTime})")
    public int insertDoc(Document document);

    @Update("update Document set Content=#{Content} where DocID=#{DocID}")
    public int updateCon(Document document);

    @Update("update Document set Privilege=#{Privilege} where DocID=#{DocID}")
    public int updatePri(Document document);

    @Update("update Document set RecycleDateTime=#{RecycleDateTime},IsRecycle=#{IsRecycle} where DocID=#{DocID}")
    public int updateRec(Document document);

}
