package com.ztpai.projekt.meeme.data;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Community {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String nickname;

    @ManyToMany(mappedBy =  "communities")
    Set<User> users;

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
