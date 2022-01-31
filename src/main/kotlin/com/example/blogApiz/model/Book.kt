package com.example.blogApiz.model

import javax.persistence.*

@Entity
@Table(name = "persons")
class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long = 0

    @Column(name = "first_name")
    private val firstName: String? = null

    @Column(name = "last_name")
    private val lastName: String? = null
}