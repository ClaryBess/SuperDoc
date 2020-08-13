package com.example.test.service;

import com.example.test.bean.Team;
import com.example.test.bean.User;

public interface TeamService {
    //创建团队
    Team createTeam(String teamname);

    //选择团队
    //修改团队信息
    void modifyTeam(Team team);

    //添加团队成员
    void addMember(User user);

    //删除团队成员
    void dropMember(User user);

    //修改团队权限
    void modifyPrivilege(Team team);

    //解散团队
    void removeTeam(Team team);
}
