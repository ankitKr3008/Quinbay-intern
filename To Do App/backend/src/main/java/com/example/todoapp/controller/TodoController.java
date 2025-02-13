// package com.example.todoapp.controller;

// import com.example.todoapp.model.Todo;
// import com.example.todoapp.service.TodoService;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/todos")
// @CrossOrigin(origins = "*") // Enable CORS for frontend
// public class TodoController {

//     private final TodoService todoService;

//     public TodoController(TodoService todoService) {
//         this.todoService = todoService;
//     }

//     // @GetMapping
//     // public List<Todo> getTodos() {
//     //     return todoService.getAllTodos();
//     // }

//     // @PostMapping
//     // public Todo addTodo(@RequestBody Todo todo) {
//     //     return todoService.addTodo(todo.getTask());
//     // }

//     // @DeleteMapping("/{id}")
//     // public void deleteTodo(@PathVariable String id) {
//     //     todoService.deleteTodo(id);
//     // }

//     // @PutMapping("/{id}/complete")
//     // public Todo completeTodo(@PathVariable String id) {
//     //     return todoService.markAsCompleted(id);
//     // }
// }

// Main routes from here

package com.example.todoapp.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.example.todoapp.service.TodoService;
import com.example.todoapp.model.Todo;
@RestController
@RequestMapping("/api") // Base URL for all routes in this controller
public class TodoController {

    @GetMapping("/test")
    public String testServer() {
        return "✅ Server is running!";
    }
}

// end of the main routes
