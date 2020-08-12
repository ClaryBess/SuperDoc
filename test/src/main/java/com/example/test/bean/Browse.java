package com.example.test.bean;

import java.sql.Date;

public class Browse {

    private Integer BrowseID;
    private Integer DocID;
    private Integer UserID;
    private Date DateTime;

    public Integer getBrowseID() {
        return BrowseID;
    }

    public void setBrowseID(Integer browseID) {
        BrowseID = browseID;
    }

    public Integer getDocID() {
        return DocID;
    }

    public void setDocID(Integer docID) {
        DocID = docID;
    }

    public Integer getUserID() {
        return UserID;
    }

    public void setUserID(Integer userID) {
        UserID = userID;
    }

    public Date getDateTime() {
        return DateTime;
    }

    public void setDateTime(Date dateTime) {
        DateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Browse{" +
                "BrowseID=" + BrowseID +
                ", DocID=" + DocID +
                ", UserID=" + UserID +
                ", DateTime=" + DateTime +
                '}';
    }
}
