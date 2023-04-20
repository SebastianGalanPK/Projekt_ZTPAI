package com.ztpai.projekt.meeme.data;

import jakarta.persistence.*;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "role")
    private String roleName;

    public Role(String roleName){
        this.roleName = roleName;
    }

    public int getID(){
        return id;
    }

    public String getRoleName(){
        return roleName;
    }
}
