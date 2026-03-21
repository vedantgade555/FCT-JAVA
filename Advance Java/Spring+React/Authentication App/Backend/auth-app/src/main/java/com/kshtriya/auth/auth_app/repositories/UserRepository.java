package com.kshtriya.auth.auth_app.repositories;

import com.kshtriya.auth.auth_app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByEmail(String email); // when we use optional we does not require to implement ir
    boolean existsByEmail(String email);
}
