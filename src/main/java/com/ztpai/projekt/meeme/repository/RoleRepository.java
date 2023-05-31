package com.ztpai.projekt.meeme.repository;

import com.ztpai.projekt.meeme.data.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findById(int id);
}
