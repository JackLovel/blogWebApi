package com.example.blogApi;

import com.example.blogApi.entity.Person;
import com.example.blogApi.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlogApiApplication implements CommandLineRunner {

    public static void main(String[] args) {
		SpringApplication.run(BlogApiApplication.class, args);
	}

    @Autowired
    private PersonRepo personRepo;

    @Override
    public void run(String... args) throws Exception {
        Person person = new Person();
        person.setLastName("gog");
        person.setFirstName("swcc");
        personRepo.save(person);

        Person person2 = new Person();
        person2.setLastName("gog1");
        person2.setFirstName("swcc1");
        personRepo.save(person2);
    }
}
