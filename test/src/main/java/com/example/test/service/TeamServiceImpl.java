package com.example.test.service;

import com.example.test.bean.Team;
import com.example.test.bean.User;
import com.example.test.mapper.TeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    TeamMapper teamMapper;

    /**
     * 创建团队
     * @param name
     * @return
     */
    @Override
    public Team createTeam(String name){
        Team team1 = teamMapper.selectTeamByName(name);
        if(team1 == null){
            return teamMapper.newTeam(name);
        }
        else
            return null;
    }

    /**
     * 修改团队信息
     * @param team
     * @return
     */
    @Override
    public void modifyTeam(Team team){

        teamMapper.updateTeam(team);
    }

    /**
     * 添加团队成员
     * @param user
     * @return
     */
    @Override
    public void addMember(User user){

        teamMapper.insertMember(user);
    }

    /**
     * 删除团队成员
     * @param user
     * @return
     */
    @Override
    public void dropMember(User user){

        teamMapper.deleteMember(user);
    }

    /**
     * 修改团队权限
     * @param team
     * @return
     */
    @Override
    public void modifyPrivilege(Team team){
        teamMapper.changePrivilege(team);
    }

    /**
     * 解散团队
     * @param team
     * @return
     */
    public void removeTeam(Team team){

        teamMapper.disbandTeam(team);
    }

}
