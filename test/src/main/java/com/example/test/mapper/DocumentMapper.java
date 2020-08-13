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

    @Options(useGeneratedKeys = true,keyProperty = "DocID")
    @Insert("insert into Document(UserID,Title,Content,Privilege,IsTeam,Team,RecycleDateTime) values(#{UserID},#{Title},#{Content},#{Privilege},#{IsTeam},#{Team},#{RecycleDateTime})")
    public int insertDoc(Document document);

    @Update("update Document set Content=#{Content} where DocID=#{DocID}")
    public int updateCon(Document document);

    @Update("update Document set Privilege=#{Privilege} where DocID=#{DocID}")
    public int updatePri(Document document);

    @Update("update Document set RecycleDateTime=#{RecycleDateTime},IsRecycle=#{IsRecycle} where DocID=#{DocID}")
    public int updateRec(Document document);

    @Update("update Document set IsTeam=#{IsTeam},Team=#{Team} where DocID=#{DocID}")
    public int updateTea(Document document);

    @Update("update Document set Editable=#{Editable} where DocID=#{DocID}")
    public int updateEdi(Document document);

    @Update("update Document set CommentNumber=CommentNumber+1 where DocID=#{DocID}")
    public int commentDoc(Integer DocID);

    @Update("update Document set CollectNumber=CollectNumber+1 where DocID=#{DocID}")
    public int collectDoc(Integer DocID);

}
