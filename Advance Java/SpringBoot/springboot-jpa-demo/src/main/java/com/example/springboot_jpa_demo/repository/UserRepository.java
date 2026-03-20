package com.example.springboot_jpa_demo.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot_jpa_demo.entity.*;

public interface UserRepository extends JpaRepository<User,Integer>{
	Optional<User> findByUsername(String username);

	Optional<User> findByUsername(String username);
}
