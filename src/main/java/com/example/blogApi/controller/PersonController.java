package com.example.blogApi.controller;

import com.example.blogApi.entity.Person;
import com.example.blogApi.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/employees")
public class PersonController {

    @Autowired
    private PersonRepo personRepo;


    /**
     * 返回所有员工
     *
     * @return
     */
    @GetMapping
    public List<Person> getAllPerson() {
        return personRepo.findAll();
    }

    /**
     * 添加员工
     * @param person
     * @return
     */
    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return personRepo.save(person);
    }
}