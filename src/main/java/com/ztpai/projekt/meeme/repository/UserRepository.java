package com.ztpai.projekt.meeme.repository;

import com.ztpai.projekt.meeme.data.Meme;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class UserRepository {

    public int addUser(String login, String password, String email){
        //TODO Sprawdzić, czy nie ma usera z podanym loginem, email

        try{
            PreparedStatement ps = DataBase.getInstance().con.prepareStatement("INSERT INTO public.\"User\"(login, password, email, id_role) VALUES (?, ?, ?, ?);");
            ps.setString(1, login);
            ps.setString(2, password);
            ps.setString(3, email);
            ps.setInt(4,1);

            ps.executeUpdate();
            ps.close();
        }catch (SQLException e){
            e.printStackTrace();
            return -1;
        }

        return 1;
    }
}
