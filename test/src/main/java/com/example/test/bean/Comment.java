package com.example.test.bean;

import java.sql.Date;

public class Comment {

    private Integer CommentID;
    private Integer DocID;
    private Integer UserID;
    private Date DateTime;
    private String Content;

    public Integer getCommentID() {
        return CommentID;
    }

    public void setCommentID(Integer commentID) {
        CommentID = commentID;
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

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "CommentID=" + CommentID +
                ", DocID=" + DocID +
                ", UserID=" + UserID +
                ", DateTime=" + DateTime +
                ", Content='" + Content + '\'' +
                '}';
    }
}
