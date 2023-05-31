package com.ztpai.projekt.meeme.repository;

import com.ztpai.projekt.meeme.data.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByLogin(String login);
    Optional<User> findByEmail(String email);
}
