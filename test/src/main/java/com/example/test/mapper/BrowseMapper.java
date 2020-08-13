package com.example.test.mapper;

import com.example.test.bean.Browse;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BrowseMapper {

    @Select("select * from Browse where BrowseID=#{BrowseID}")
    public Browse getBrowseById(Integer BrowseID);

    @Select("select * from Browse where UserID=#{UserID}")
    public List<Browse> getBrowseByUser(Integer UserID);

    @Options(useGeneratedKeys = true,keyProperty = "BrowseID")
    @Insert("insert into Browse(DocID,UserID) values(#{DocID},#{UserID})")
    public int insertBrowse(Browse browse);

    @Delete("delete from Browse where BrowseID=#{BrowseID}")
    public int deleteBrowseById(Integer BrowseID);

    @Delete("delete from Browse where DocID=#{DocID}")
    public int deleteBrowseByDoc(Integer DocID);

    @Delete("delete from Browse where UserID=#{UserID}")
    public int deleteBrowseByUser(Integer UserID);

    @Update("update Browse set DateTime=now() where BrowseID=#{BrowseID}")
    public int updateDateTime(Integer BrowseID);

}
