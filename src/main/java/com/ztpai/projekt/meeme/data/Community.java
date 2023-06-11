package com.ztpai.projekt.meeme.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="community")
public class Community {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String nickname;

    @OneToMany(mappedBy = "community")
    private Set<Meme> memes;

    public Community(String name, String nickname) {
        this.name = name;
        this.nickname = nickname;
    }

    public Community(int id) {
        this.id = id;
    }
}
