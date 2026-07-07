package com.vedant.controller;

import com.vedant.model.Task;
import com.vedant.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    // Get all tasks for the logged-in user
    @GetMapping
    public List<Task> getTasks(@AuthenticationPrincipal Jwt jwt) {
        // The subject claim in Supabase JWT is the User's UUID
        String userId = jwt.getSubject();
        return taskRepository.findByUserId(userId);
    }

    // Create a new task for the logged-in user
    @PostMapping
    public Task createTask(@AuthenticationPrincipal Jwt jwt, @RequestBody Task task) {
        String userId = jwt.getSubject();
        task.setUserId(userId);
        return taskRepository.save(task);
    }

    // Update task status
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @AuthenticationPrincipal Jwt jwt, @RequestBody Task taskDetails) {
        String userId = jwt.getSubject();
        
        Task task = taskRepository.findById(id).orElse(null);
        if (task == null || !task.getUserId().equals(userId)) {
            return ResponseEntity.notFound().build();
        }

        task.setTitle(taskDetails.getTitle());
        task.setCompleted(taskDetails.isCompleted());
        Task updatedTask = taskRepository.save(task);
        
        return ResponseEntity.ok(updatedTask);
    }

    // Delete a task
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id, @AuthenticationPrincipal Jwt jwt) {
        String userId = jwt.getSubject();
        
        Task task = taskRepository.findById(id).orElse(null);
        if (task == null || !task.getUserId().equals(userId)) {
            return ResponseEntity.notFound().build();
        }

        taskRepository.delete(task);
        return ResponseEntity.ok().build();
    }
}
