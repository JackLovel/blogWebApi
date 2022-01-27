package com.example.blogApiz.repo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PersonRepoTest {

    @Autowired
    public PersonRepo personRepo;

    @Test
    public void getPerson() {
    }
}