package com.ztpai.projekt.meeme.repository;

import com.ztpai.projekt.meeme.data.Meme;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemeRepository {


    public int addMeme(Meme meme){
        try{
            Date date = new Date();
            PreparedStatement ps = DataBase.getInstance().con.prepareStatement("INSERT INTO public.\"Meme\"(id_user, id_community, post_date, text, file_name) VALUES (?, ?, ?, ?, ?);");
            ps.setInt(1, meme.getUserID());
            ps.setInt(2, meme.getCommunityID());
            ps.setDate(3, new java.sql.Date(date.getTime()));
            ps.setString(4, meme.getText());
            ps.setString(5, meme.getFileName());

            ps.executeUpdate();
            ps.close();
        }catch (SQLException e){
            e.printStackTrace();
            return -1;
        }

        return 1;
    }
    public int removeMeme(int id){
        try{
            PreparedStatement ps = DataBase.getInstance().con.prepareStatement("DELETE FROM public.\"Meme\" WHERE id = ?");
            ps.setInt(1, id);

            ps.executeUpdate();
            ps.close();
        }catch (SQLException e){
            e.printStackTrace();
            return -1;
        }

        return 1;
    }
    public int rateMeme(int id, int rate_value){
        try{
            PreparedStatement ps = DataBase.getInstance().con.prepareStatement("");
            //TODO

            ps.executeUpdate();
            ps.close();
        }catch (SQLException e){
            e.printStackTrace();
            return -1;
        }

        return 1;
    }
    public int switchFavouriteMeme(int id){
        try{
            PreparedStatement ps = DataBase.getInstance().con.prepareStatement("");
            //TODO

            ps.executeUpdate();
            ps.close();
        }catch (SQLException e){
            e.printStackTrace();
            return -1;
        }

        return 1;
    }

    public List<Meme> getMemesByCommunityID(int id){
        List<Meme> memes = new ArrayList<>();

        try{
            PreparedStatement ps = DataBase.getInstance().con.prepareStatement("SELECT * FROM public.\"Meme\" WHERE id_community = ? ORDER BY post_date DESC");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                memes.add(new Meme(
                        rs.getInt("id"),
                        rs.getInt("id_user"),
                        rs.getInt("id_community"),
                        rs.getDate("post_date"),
                        rs.getString("text"),
                        rs.getString("file_name")
                        ));
            }

            rs.close();
            ps.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

        return memes;
    }

    public List<Meme> getFavourite(){
        List<Meme> memes = new ArrayList<>();

        try{
            PreparedStatement ps = DataBase.getInstance().con.prepareStatement("");
            //TODO

            ps.executeUpdate();
            ps.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

        return memes;
    }

    public List<Meme> getLast(){
        List<Meme> memes = new ArrayList<>();

        try{
            PreparedStatement ps = DataBase.getInstance().con.prepareStatement("");
            //TODO

            ps.executeUpdate();
            ps.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

        return memes;
    }

    public List<Meme> getTop(){
        List<Meme> memes = new ArrayList<>();

        try{
            PreparedStatement ps = DataBase.getInstance().con.prepareStatement("");
            //TODO

            ps.executeUpdate();
            ps.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

        return memes;
    }
}
