package com.kshtriya.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kshtriya.springboot.model.Person;

public interface  PersonRepository extends JpaRepository<Person, Long> {
	
}
