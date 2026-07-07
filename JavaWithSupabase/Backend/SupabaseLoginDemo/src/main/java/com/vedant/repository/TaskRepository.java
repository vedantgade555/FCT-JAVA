package com.vedant.repository;

import com.vedant.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    
    // Find all tasks associated with a specific Supabase user
    List<Task> findByUserId(String userId);
}
