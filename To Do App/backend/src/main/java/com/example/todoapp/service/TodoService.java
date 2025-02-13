// package com.example.todoapp.service;

// import com.example.todoapp.model.Todo;
// import com.example.todoapp.repository.TodoRepository;
// import org.springframework.stereotype.Service;
// import java.util.List;

// @Service
// public class TodoService {
//     private final TodoRepository repository;

//     public TodoService(TodoRepository repository) {
//         this.repository = repository;
//     }

//     // public List<Todo> getAllTodos() {
//     //     return repository.findAll();
//     // }

//     // public Todo addTodo(Todo todo) {
//     //     return repository.save(todo);
//     // }

//     public void deleteTodoById(String id) {
//         repository.deleteById(id);
//     }

//     // public Todo markAsCompleted(String id) {
//     // //     Todo todo = repository.findById(id).orElseThrow();
//     // //     todo.setCompleted(true);
//     // //     return repository.save(todo);
//     //  }
// }

package com.example.todoapp.service;

import com.example.todoapp.model.Todo;
import com.example.todoapp.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    // Constructor-based dependency injection
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    /**
     * Fetch all TODO items from the database.
     * @return List of Todo items.
     */
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    /**
     * Add a new TODO item.
     * @param task The task description.
     * @return The saved Todo item.
     */
    public Todo addTodo(String task) {
        Todo newTodo = new Todo(task);
        return todoRepository.save(newTodo);
    }

    /**
     * Delete a TODO item by its ID.
     * @param id The ID of the Todo item.
     */
    public void deleteTodo(String id) {
        todoRepository.deleteById(id);
    }

    /**
     * Mark a TODO item as completed.
     * @param id The ID of the Todo item.
     * @return The updated Todo item.
     */
    public Todo markAsCompleted(String id) {
        Optional<Todo> todoOptional = todoRepository.findById(id);
        System.out.println((todoOptional));
        if (todoOptional.isPresent()) {
            Todo todo = todoOptional.get();
            todo.setCompleted(true);
            return todoRepository.save(todo);
        } else {
            throw new RuntimeException("Todo item not found with id: " + id);
        }
    }
}
