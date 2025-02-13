document.addEventListener("DOMContentLoaded", function () {
    const todoText = document.getElementById("todo-text");
    const addButton = document.getElementById("add-btn");
    const todoList = document.getElementById("todo-list");
    const completedCount = document.getElementById("completed-count");

    let completedTodos = 0;

    function updateCompletedCount() {
        completedCount.textContent = completedTodos;
    }

    function addTodo() {
        const text = todoText.value.trim();
        if (text === "") return;

        const li = document.createElement("li");
        li.innerHTML = `
            <span>${text}</span>
            <div class="action-buttons">
                <button class="check-btn">✔</button>
                <button class="delete-btn">✖</button>
            </div>
        `;

        // Mark complete
        li.querySelector(".check-btn").addEventListener("click", function () {
            li.classList.toggle("completed");
            completedTodos += li.classList.contains("completed") ? 1 : -1;
            updateCompletedCount();
        });

        // Delete task
        li.querySelector(".delete-btn").addEventListener("click", function () {
            if (li.classList.contains("completed")) {
                completedTodos--;
            }
            li.remove();
            updateCompletedCount();
        });

        todoList.appendChild(li);
        todoText.value = "";
    }

    addButton.addEventListener("click", addTodo);
    todoText.addEventListener("keypress", function (e) {
        if (e.key === "Enter") addTodo();
    });
});
            