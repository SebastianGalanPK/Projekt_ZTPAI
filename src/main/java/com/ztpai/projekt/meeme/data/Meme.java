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
@Table(name="meme")
public class Meme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String text;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "post_date")
    private Date postDate;

    @ManyToOne
    @JoinColumn(name="id_user", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name="id_community", referencedColumnName = "id")
    private Community community;
}
