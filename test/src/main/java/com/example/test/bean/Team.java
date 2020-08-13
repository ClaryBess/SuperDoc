package com.example.test.bean;

import java.util.Date;

public class Team {
    private int TeamID;
    private String TeamName;
    private int MemberNumber;
    private int Privilege;
    private Date DateTime;

    public int getTeamID() {
        return TeamID;
    }

    public void setTeamID(int teamID) {
        TeamID = teamID;
    }

    public String getTeamName() {
        return TeamName;
    }

    public void setTeamName(String teamName) {
        TeamName = teamName;
    }

    public int getMemberNumber() {
        return MemberNumber;
    }

    public void setMemberNumber(int memberNumber) {
        MemberNumber = memberNumber;
    }

    public int getPrivilege() {
        return Privilege;
    }

    public void setPrivilege(int privilege) {
        Privilege = privilege;
    }

    public Date getDateTime() {
        return DateTime;
    }

    public void setDateTime(Date dateTime) {
        DateTime = dateTime;
    }
}
