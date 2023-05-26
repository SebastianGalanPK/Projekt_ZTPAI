package com.ztpai.projekt.meeme.repository;

import com.ztpai.projekt.meeme.data.Meme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemeRepository extends JpaRepository<Meme, Long> {

    //@Query("SELECT \"Meme\".id id_meme, \"Meme\".file_name, \"Meme\".text, u.login, \"Meme\".\"ID_Community\", c.nickname, coalesce(sum(RM.rate_value), 0) rate FROM \"Meme\" LEFT OUTER JOIN \"RateMeme\" RM on \"Meme\".id = RM.\"ID_Meme\" INNER JOIN \"User\" U on U.id = \"Meme\".\"ID_User\" INNER JOIN \"Community\" C on C.id = \"Meme\".\"ID_Community\" GROUP BY \"Meme\".id, u.login, c.nickname ORDER BY rate DESC;")
    //List<Meme> getTopMemes();
}
