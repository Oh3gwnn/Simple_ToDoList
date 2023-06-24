package com.my.ToDoList;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private final List<TodoDto> todoList = new ArrayList<>();
    private Long nextId = 1L;

    public TodoDto createToDo(String content) {
        TodoDto newTodo = new TodoDto(nextId, content, false);
        nextId++;
        todoList.add(newTodo);
        return newTodo;
    }

    public List<TodoDto> readAll() {
        return todoList;
    }
}
