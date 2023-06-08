package com.ztpai.projekt.meeme.repository;

import com.ztpai.projekt.meeme.data.Community;
import com.ztpai.projekt.meeme.data.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface CommunityRepository extends JpaRepository<Community, Long> {

    @Query("SELECT c FROM Community c WHERE c.nickname LIKE :searchTerm% OR c.name LIKE :searchTerm%")
    List<Community> searchCommunity(@Param("searchTerm") String searchTerm);
}
