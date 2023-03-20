package com.ztpai.projekt.meeme.data;

import java.util.Date;

public class Meme {

    private int id;

    private String text;
    private String fileName;

    private Date postDate;

    private int userID;
    private int communityID;

    private String communityNickname;
    private String userLogin;

    private final String UPLOAD_DIRECTORY = "/../public/uploads/";

    public Meme(int id, String text, String fileName, String userLogin, String communityNickname, Date postDate) {
        this.id = id;
        this.text = text;
        this.fileName = fileName;
        this.postDate = postDate;
        this.communityNickname = communityNickname;
        this.userLogin = userLogin;
    }

    public Meme(String text, String fileName, int userID, int communityID) {
        this.text = text;
        this.fileName = fileName;
        this.userID = userID;
        this.communityID = communityID;
    }

    public Meme(int id, int userID, int communityID, Date postDate, String text, String fileName) {
        this.id = id;
        this.userID = userID;
        this.communityID = communityID;
        this.text = text;
        this.fileName = fileName;
    }

    public int getId() {
        return id;
    }
    public String getText() {
        return text;
    }
    public String getFileName() {
        return fileName;
    }
    public int getUserID() {
        return userID;
    }

    public int getCommunityID() {
        return communityID;
    }
    public Date getPostDate() {
        return postDate;
    }
    public String getCommunityNickname() {
        return communityNickname;
    }
    public String getUserLogin() {
        return userLogin;
    }
}
