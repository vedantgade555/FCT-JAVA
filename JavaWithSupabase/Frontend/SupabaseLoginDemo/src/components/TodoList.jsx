import React, { useState, useEffect } from 'react';
import { supabase } from '../supabaseClient';
import { Container, Button, ListGroup, Form, InputGroup } from 'react-bootstrap';

export default function TodoList({ session }) {
  const [tasks, setTasks] = useState([]);
  const [newTask, setNewTask] = useState('');

  // Fetch tasks from Spring Boot backend
  const fetchTasks = async () => {
    try {
      const response = await fetch('http://localhost:8080/api/tasks', {
        headers: {
          'Authorization': `Bearer ${session.access_token}`
        }
      });
      if (response.ok) {
        const data = await response.json();
        setTasks(data);
      } else {
        console.error('Failed to fetch tasks');
      }
    } catch (error) {
      console.error('Error fetching tasks:', error);
    }
  };

  useEffect(() => {
    fetchTasks();
  }, [session]);

  const addTask = async (e) => {
    e.preventDefault();
    if (!newTask.trim()) return;

    try {
      const response = await fetch('http://localhost:8080/api/tasks', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${session.access_token}`
        },
        body: JSON.stringify({ title: newTask, completed: false })
      });

      if (response.ok) {
        setNewTask('');
        fetchTasks();
      }
    } catch (error) {
      console.error('Error adding task:', error);
    }
  };

  const toggleTask = async (task) => {
    try {
      await fetch(`http://localhost:8080/api/tasks/${task.id}`, {
        method: 'PUT',
        headers: {
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${session.access_token}`
        },
        body: JSON.stringify({ ...task, completed: !task.completed })
      });
      fetchTasks();
    } catch (error) {
      console.error('Error updating task:', error);
    }
  };

  const deleteTask = async (taskId) => {
    try {
      await fetch(`http://localhost:8080/api/tasks/${taskId}`, {
        method: 'DELETE',
        headers: {
          'Authorization': `Bearer ${session.access_token}`
        }
      });
      fetchTasks();
    } catch (error) {
      console.error('Error deleting task:', error);
    }
  };

  return (
    <Container className="mt-5" style={{ maxWidth: '600px' }}>
      <div className="d-flex justify-content-between align-items-center mb-4">
        <h2>My Tasks</h2>
        <Button variant="outline-danger" onClick={() => supabase.auth.signOut()}>
          Sign Out
        </Button>
      </div>

      <Form onSubmit={addTask} className="mb-4">
        <InputGroup>
          <Form.Control
            placeholder="Add a new task..."
            value={newTask}
            onChange={(e) => setNewTask(e.target.value)}
          />
          <Button type="submit" variant="primary">Add</Button>
        </InputGroup>
      </Form>

      <ListGroup>
        {tasks.map(task => (
          <ListGroup.Item key={task.id} className="d-flex justify-content-between align-items-center">
            <div>
              <Form.Check 
                type="checkbox" 
                checked={task.completed} 
                onChange={() => toggleTask(task)} 
                label={<span style={{ textDecoration: task.completed ? 'line-through' : 'none' }}>{task.title}</span>} 
              />
            </div>
            <Button variant="danger" size="sm" onClick={() => deleteTask(task.id)}>Delete</Button>
          </ListGroup.Item>
        ))}
        {tasks.length === 0 && <p className="text-center text-muted">No tasks yet. Add one above!</p>}
      </ListGroup>
    </Container>
  );
}
