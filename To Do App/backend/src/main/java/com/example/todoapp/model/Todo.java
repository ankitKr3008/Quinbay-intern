package com.example.todoapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "todos")  // MongoDB Collection Name
public class Todo {
    
    @Id
    private String id;
    private String task;
    private boolean completed;

    public Todo() {}

    public Todo(String task) {
        this.task = task;
        this.completed = false;
    }

    public String getId() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
