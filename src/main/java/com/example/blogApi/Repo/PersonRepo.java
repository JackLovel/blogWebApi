package com.example.blogApi.Repo;

import com.example.blogApi.entity.Person;
import org.springframework.data.repository.query.Param;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PersonRepo extends PagingAndSortingRepository<Person, Long> {
    List<Person> findByLastName(@Param("name") String name);
}