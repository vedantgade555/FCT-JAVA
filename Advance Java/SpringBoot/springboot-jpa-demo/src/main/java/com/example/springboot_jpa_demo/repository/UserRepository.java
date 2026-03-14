package com.example.springboot_jpa_demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot_jpa_demo.entity.*;

public interface UserRepository extends JpaRepository<User,Integer>{
	
}
