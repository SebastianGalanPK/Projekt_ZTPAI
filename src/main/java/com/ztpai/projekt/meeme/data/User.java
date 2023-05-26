package com.ztpai.projekt.meeme.data;

import java.util.Set;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
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
            name = "liked_community",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_community")
    )
    private Set<Community> communities;

    @ManyToMany
    @JoinTable(
            name = "favourite_meme",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_meme")
    )
    private Set<Meme> favouriteMemes;

    @OneToMany(mappedBy = "user")
    private Set<Meme> ownMemes;

    public User(String login, String password, String email){
        this.login = login;
        this.password = password;
        this.email = email;

        this.rankID = 1;
    }

    public User(int id){
        this.id = id;
    }
}
