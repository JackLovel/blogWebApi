package com.example.blogApiz.repo;

import com.example.blogApiz.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepo extends JpaRepository<Person, Long> {
}