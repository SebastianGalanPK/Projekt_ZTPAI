package com.ztpai.projekt.meeme.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Meme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String text;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "post_date")
    private Date postDate;

    @Column(name = "id_user")
    private int userID;
    @Column(name = "id_community")
    private int communityID;

    private String communityNickname;
    private String userLogin;

    @ManyToMany(mappedBy =  "favouriteMemes")
    private Set<User> favouriteUsers;

    private final String UPLOAD_DIRECTORY = "/../public/uploads/";
}
