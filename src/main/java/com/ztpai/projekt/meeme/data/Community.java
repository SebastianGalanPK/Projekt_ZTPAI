package com.ztpai.projekt.meeme.data;

public class Community {

    private int id;
    private String name;
    private String nickname;

    public Community(int id, String name, String nickname) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
    }

    public Community(String name, String nickname) {
        this.name = name;
        this.nickname = nickname;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }
}
