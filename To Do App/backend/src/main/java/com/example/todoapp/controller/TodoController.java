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

// package com.example.todoapp.controller;

// import org.springframework.web.bind.annotation.*;

// import java.util.List;
// import com.example.todoapp.service.TodoService;
// import com.example.todoapp.model.Todo;
// @RestController
// @RequestMapping("/api") // Base URL for all routes in this controller
// public class TodoController {

//     @GetMapping("/test")
//     public String testServer() {
//         return "✅ Server is running!";
//     }
// }

// end of the main routes
package com.example.todoapp.controller;

import com.example.todoapp.model.Todo;
import com.example.todoapp.service.TodoService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")  // Base URL for all endpoints
@CrossOrigin(origins = "*") // Enable CORS for frontend
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    /**
     * 🔹 Endpoint: GET /todos
     * 🔹 Request Type: GET
     * 🔹 Description: Fetches all TODO items
     */
    @GetMapping
    public List<Todo> getTodos() {
        return todoService.getAllTodos();
    }

    /**
     * 🔹 Endpoint: POST /todos
     * 🔹 Request Type: POST
     * 🔹 Description: Adds a new TODO item
     * 🔹 Request Body: { "task": "Example task" }
     */
    @PostMapping
    public Todo addTodo(@RequestBody Todo todo) {
        return todoService.addTodo(todo.getTask());
    }

    /**
     * 🔹 Endpoint: DELETE /todos/{id}
     * 🔹 Request Type: DELETE
     * 🔹 Description: Deletes a TODO item by ID
     * 🔹 Path Variable: id (String)
     */
    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable(name = "id") String id) {  
        todoService.deleteTodo(id);
    }
    
    
    /**
     * 🔹 Endpoint: PUT /todos/{id}/complete
     * 🔹 Request Type: PUT
     * 🔹 Description: Marks a TODO item as completed
     * 🔹 Path Variable: id (String)
     */
    @PutMapping("/{id}/complete")
    // public Todo completeTodo(@PathVariable String id) {
    
    //     return todoService.markAsCompleted(id);
    // }
   

    public ResponseEntity<Todo> completeTodo(@PathVariable("id") String id) {
        System.out.println("Completing TODO with ID: " + id);
        Todo updatedTodo = todoService.markAsCompleted(id);
        return ResponseEntity.ok(updatedTodo);
    }
    
    /**
     * 🔹 Endpoint: GET /
     * 🔹 Request Type: GET
     * 🔹 Description: Test route to check if server is running
     */
    @GetMapping("/")
    public String home() {
        return "Server is running!";
    }
}
