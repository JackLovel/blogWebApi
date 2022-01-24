package com.example.blogApi.controller;

import com.example.blogApi.entity.Person;
import com.example.blogApi.exception.ResourceNotFoundException;
import com.example.blogApi.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    /**
     * 查找单个员工
     * @param id 工号
     * @return
     */
    @GetMapping("{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable long id) {
        Person person = personRepo.findById(id).orElseThrow(()
                ->new ResourceNotFoundException("用户不存在"));

        return ResponseEntity.ok(person);
    }

    /**
     * 查找单个员工
     * @param id 工号
     * @return
     */
    @PutMapping("{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable long id, @RequestBody Person personDetails) {
        Person updatePerson = personRepo.findById(id).orElseThrow(()
                ->new ResourceNotFoundException("用户不存在" + id));

        updatePerson.setFirstName(personDetails.getFirstName());
        updatePerson.setLastName(personDetails.getLastName());

        personRepo.save(updatePerson);

        return ResponseEntity.ok(updatePerson);
    }

    /**
     * 删除单个员工
     * @param id 工号
     * @return
     */
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deletePerson(@PathVariable long id) {
        Person person = personRepo.findById(id).orElseThrow(()
                ->new ResourceNotFoundException("用户不存在" + id));

            personRepo.delete(person);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}