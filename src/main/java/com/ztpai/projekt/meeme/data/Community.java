package com.ztpai.projekt.meeme.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Community {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String nickname;

    @ManyToMany(mappedBy =  "communities")
    Set<User> users;

    public Community(String name, String nickname) {
        this.name = name;
        this.nickname = nickname;
    }
}
