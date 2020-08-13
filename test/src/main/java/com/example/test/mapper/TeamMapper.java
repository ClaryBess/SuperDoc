package com.example.test.mapper;

import com.example.test.bean.Team;
import com.example.test.bean.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface TeamMapper {

    //创建团队
    @Options(useGeneratedKeys = true,keyProperty = "TeamID")
    @Insert("insert into Team(TeamName,DateTime) values(#{TeamName},sysdate())")
    Team newTeam(String TeamName);

    //修改团队信息
    @Update("update Team set TeamName=#{TeamName} where TeamID=#{TeamID}")
    int updateTeam(Team team);

    //添加团队成员
    @Insert("insert into Member(MemberID,Team ID)")
    int insertMember(User user);

    //删除团队成员
    @Delete("delete from Member where UserID=#{UserID}")
    int deleteMember(User user);

    //修改团队权限
    @Update("update Team set Privilege=#{Privilege}")
    int changePrivilege(Team team);

    //解散团队
    @Delete("delete from Team where TeamID=#{TeamID}")
    int disbandTeam(Team team);

    //根据团队id选择团队
    @Select("select * from Team where TeamID=#{id}")
    Team selectTeamById(String id);

    //根据团队名称选择团队
    @Select("select * from Team where TeamName=#{name}")
    Team selectTeamByName(String name);
}
