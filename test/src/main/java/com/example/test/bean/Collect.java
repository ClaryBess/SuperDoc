package com.example.test.bean;

import java.sql.Date;

public class Collect {

    private Integer CollectID;
    private Integer DocID;
    private Integer UserID;
    private Date DateTime;

    public Integer getCollectID() {
        return CollectID;
    }

    public void setCollectID(Integer collectID) {
        CollectID = collectID;
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
        return "Collect{" +
                "CollectID=" + CollectID +
                ", DocID=" + DocID +
                ", UserID=" + UserID +
                ", DateTime=" + DateTime +
                '}';
    }
}
