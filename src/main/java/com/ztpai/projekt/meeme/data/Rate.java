package com.ztpai.projekt.meeme.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="rate_meme")
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //@ManyToOne
    //@JoinColumn(name="id_user", referencedColumnName = "id")
    private User user;

    //@ManyToOne
    //@JoinColumn(name="id_meme", referencedColumnName = "id")
    private Meme meme;

    @Column(name = "rate_value")
    private int value;
}
