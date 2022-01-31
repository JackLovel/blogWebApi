package com.example.blogApiz.repo;

import com.example.blogApiz.entity.Role;
import com.example.blogApiz.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
    User findByUsername(String username);
}






