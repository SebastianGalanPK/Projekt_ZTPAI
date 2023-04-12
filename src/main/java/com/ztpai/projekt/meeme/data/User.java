package com.ztpai.projekt.meeme.data;

import java.util.List;
import java.util.Set;

import jakarta.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String login;
    private String password;
    private String email;
    @Column(name = "id_role")
    private int rankID;

    @ManyToMany
    @JoinTable(
            name = "LikedCommunity",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_community")
    )
    private Set<Community> communities;

    @ManyToMany
    @JoinTable(
            name = "FavouriteMeme",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_meme")
    )
    private Set<Meme> favouriteMemes;

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

    public Set<Community> getCommunities() {
        return communities;
    }
}
