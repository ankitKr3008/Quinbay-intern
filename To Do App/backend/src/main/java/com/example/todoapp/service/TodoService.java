package com.example.todoapp.service;

import com.example.todoapp.model.Todo;
import com.example.todoapp.repository.TodoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TodoService {
    private final TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    // public List<Todo> getAllTodos() {
    //     return repository.findAll();
    // }

    // public Todo addTodo(Todo todo) {
    //     return repository.save(todo);
    // }

    public void deleteTodoById(String id) {
        repository.deleteById(id);
    }

    // public Todo markAsCompleted(String id) {
    // //     Todo todo = repository.findById(id).orElseThrow();
    // //     todo.setCompleted(true);
    // //     return repository.save(todo);
    //  }
}
