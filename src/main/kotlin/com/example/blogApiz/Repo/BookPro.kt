package com.example.blogApiz.Repo

import com.example.blogApiz.entity.Person
import org.springframework.data.jpa.repository.JpaRepository


interface PersonRepo : JpaRepository<Person?, Long?>

