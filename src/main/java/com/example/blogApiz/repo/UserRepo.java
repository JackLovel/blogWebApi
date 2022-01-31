package com.example.blogApiz.repo;

import com.example.blogApiz.entity.Role;
import com.example.blogApiz.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    Role findByName(String name);
}






