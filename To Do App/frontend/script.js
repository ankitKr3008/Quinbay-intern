document.addEventListener("DOMContentLoaded", function () {
    const todoText = document.getElementById("todo-text");
    const addButton = document.getElementById("add-btn");
    const todoList = document.getElementById("todo-list");
    const completedCount = document.getElementById("completed-count");
    const totalTasksElement = document.getElementById("total-tasks"); 
    let info_todo = []; // Store the fetched tasks
    let completedTodos = 0;

    const API_URL = "http://localhost:8080/todos"; // Backend API URL

    function updateCompletedCount() {
        completedCount.textContent = completedTodos;
    }

    function updateTotalTasks() {
        totalTasksElement.textContent = info_todo.length; // Use the length of the array
    }

    async function fetchTodos() {
        try {
            const response = await fetch(API_URL);
            if (!response.ok) throw new Error("Failed to fetch todos");

            const todos = await response.json();
            info_todo = todos; // Store todos in the array
            todoList.innerHTML = "";
            completedTodos = 0;

            todos.forEach(todo => {
                addTodoToDOM(todo);
                if (todo.completed) completedTodos++;
            });

            updateCompletedCount();
            updateTotalTasks();
        } catch (error) {
            console.error("Error fetching todos:", error);
        }
    }

    async function addTodo() {
        const task = todoText.value.trim();
        if (task === "") return;

        try {
            const response = await fetch(API_URL, {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify({ task })
            });

            if (!response.ok) throw new Error("Failed to add todo");

            const newTodo = await response.json();
            info_todo.push(newTodo); // Add new task to array
            addTodoToDOM(newTodo);
            todoText.value = "";
            updateTotalTasks(); // Update total tasks
        } catch (error) {
            console.error("Error adding todo:", error);
        }
    }

    function addTodoToDOM(todo) {
        const li = document.createElement("li");
        li.dataset.id = todo.id; // Store ID for API calls
        li.classList.toggle("completed", todo.completed);

        li.innerHTML = `
            <span>${todo.task}</span>
            <div class="action-buttons">
                <button class="check-btn">Complete</button>
                <button class="delete-btn">Delete</button>
            </div>
        `;

        li.querySelector(".check-btn").addEventListener("click", () => completeTodo(todo.id, li));
        li.querySelector(".delete-btn").addEventListener("click", () => deleteTodo(todo.id, li));

        todoList.appendChild(li);
    }

    async function completeTodo(id, li) {
        try {
            const response = await fetch(`${API_URL}/${id}/complete`, { method: "PUT" });
            if (!response.ok) throw new Error("Failed to mark as completed");

            li.classList.toggle("completed");
            completedTodos += li.classList.contains("completed") ? 1 : -1;
            updateCompletedCount();
        } catch (error) {
            console.error("Error completing todo:", error);
        }
    }

    async function deleteTodo(id, li) {
        try {
            const response = await fetch(`${API_URL}/${id}`, { method: "DELETE" });
            if (!response.ok) throw new Error("Failed to delete todo");

            if (li.classList.contains("completed")) completedTodos--;
            info_todo = info_todo.filter(todo => todo.id !== id); // Remove from array
            li.remove();
            updateCompletedCount();
            updateTotalTasks(); // Update total tasks after deletion
        } catch (error) {
            console.error("Error deleting todo:", error);
        }
    }

    addButton.addEventListener("click", addTodo);
    todoText.addEventListener("keypress", (e) => {
        if (e.key === "Enter") addTodo();
    });

    fetchTodos();
});
