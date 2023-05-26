package com.ztpai.projekt.meeme.repository;

import com.ztpai.projekt.meeme.data.Community;
import com.ztpai.projekt.meeme.data.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface CommunityRepository extends JpaRepository<Community, Long> {
    User findById(String id);

    /*public int addCommunity(String name, String nickname){
        try{
            PreparedStatement ps = DataBase.getInstance().con.prepareStatement("INSERT INTO public.\"Community\"(name, nickname) VALUES (?, ?);");
            ps.setString(1, name);
            ps.setString(2, nickname);

            ps.executeUpdate();
            ps.close();

            return 1;
        }catch (SQLException e){
            e.printStackTrace();
        }

        return -1;
    }

    //Zwraca listę społeczności, którą lubi dany użytkownik
    public List<Community> getCommunitiesByUserID(int userID){
        List<Community> communities = new ArrayList<>();

        try{
            PreparedStatement ps = DataBase.getInstance().con.prepareStatement("SELECT c.id,c.name,c.nickname FROM public.\"Community\" c INNER JOIN public.\"LikedCommunity\" lc ON c.id = lc.id_community WHERE id_user = ?; ");
            ps.setInt(1, userID);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                communities.add(new Community(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("nickname")
                ));
            }

            rs.close();
            ps.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

        return communities;
    }

    public int getIDByNickname(String nickname){
        try{
            PreparedStatement ps = DataBase.getInstance().con.prepareStatement("SELECT id FROM public.\"Community\" WHERE nickname = ?");
            ps.setString(1, nickname);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getInt("id");
            }

            rs.close();
            ps.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

        return -1;
    }*/
}
