package com.ztpai.projekt.meeme.repository;

import com.ztpai.projekt.meeme.data.Meme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public interface MemeRepository extends JpaRepository<Meme, Long> {
}
