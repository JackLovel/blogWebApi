package com.example.blogApiz.controller

import com.example.blogApiz.entity.Person
import com.example.blogApiz.exception.ResourceNotFoundException
import com.example.blogApiz.repo.PersonRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@CrossOrigin("*")
@RestController
@RequestMapping("/book")
class BookController {

    @Autowired
    private var personRepo: PersonRepo? = null

    @GetMapping
    fun getBook() : MutableList<Person>? {
        val books = personRepo?.findAll();
        return books
    }



}


@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/employees")
class PersonController {
    @Autowired
    private val personRepo: PersonRepo? = null

    /**
     * 返回所有员工
     *
     * @return
     */
    @get:GetMapping
    val allPerson: List<Person>
        get() = personRepo!!.findAll()

    /**
     * 添加员工
     * @param person
     * @return
     */
    @PostMapping
    fun createPerson(@RequestBody person: Person): Person {
        return personRepo!!.save(person)
    }

    /**
     * 查找单个员工
     * @param id 工号
     * @return
     */
    @GetMapping("{id}")
    fun getPersonById(@PathVariable id: Long): ResponseEntity<Person> {
        val person = personRepo!!.findById(id).orElseThrow {
            ResourceNotFoundException(
                "用户不存在"
            )
        }
        return ResponseEntity.ok(person)
    }

    /**
     * 查找单个员工
     * @param id 工号
     * @return
     */
    @PutMapping("{id}")
    fun updatePerson(@PathVariable id: Long, @RequestBody personDetails: Person): ResponseEntity<Person> {
        val updatePerson = personRepo!!.findById(id).orElseThrow {
            ResourceNotFoundException(
                "用户不存在$id"
            )
        }
        updatePerson.firstName = personDetails.firstName
        updatePerson.lastName = personDetails.lastName
        personRepo.save(updatePerson)
        return ResponseEntity.ok(updatePerson)
    }

    /**
     * 删除单个员工
     * @param id 工号
     * @return
     */
    @DeleteMapping("{id}")
    fun deletePerson(@PathVariable id: Long): ResponseEntity<HttpStatus> {
        val person = personRepo!!.findById(id).orElseThrow {
            ResourceNotFoundException(
                "用户不存在$id"
            )
        }
        personRepo.delete(person)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}