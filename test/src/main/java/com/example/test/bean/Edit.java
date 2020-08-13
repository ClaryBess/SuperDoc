package com.example.test.bean;

import java.sql.Date;

public class Edit {

    private Integer EditID;
    private Integer DocID;
    private Integer UserID;
    private Date DateTime;

    public Integer getEditID() {
        return EditID;
    }

    public void setEditID(Integer editID) {
        EditID = editID;
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
        return "Edit{" +
                "EditID=" + EditID +
                ", DocID=" + DocID +
                ", UserID=" + UserID +
                ", DateTime=" + DateTime +
                '}';
    }
}
