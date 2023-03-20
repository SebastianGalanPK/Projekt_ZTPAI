package com.ztpai.projekt.meeme.data;

import java.util.List;

public class User {

    private int id;
    private String login;
    private String password;
    private String email;
    private int rankID;
    private List<Community> communities;

    public User(int id, String login, String password, String email, int rankID) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.rankID = rankID;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public int getRankID() {
        return rankID;
    }

    public List<Community> getCommunities() {
        return communities;
    }
}
