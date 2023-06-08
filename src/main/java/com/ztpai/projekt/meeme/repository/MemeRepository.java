package com.ztpai.projekt.meeme.repository;

import com.ztpai.projekt.meeme.data.Meme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemeRepository extends JpaRepository<Meme, Long> {

    @Query("SELECT m FROM Meme m WHERE m.community.nickname = :nickname")
    List<Meme> getMemeByCommunity(@Param("nickname") String nickname);
}
