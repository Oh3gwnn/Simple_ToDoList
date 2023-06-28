package com.my.ToDoList;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

@Service
public class TodoService {
    private final List<TodoDto> todoList = new ArrayList<>();
    private Long nextId = 1L;

    public void createToDo(String content) {
        TodoDto newTodo = new TodoDto(nextId, content, false);
        nextId++;
        todoList.add(newTodo);
        System.out.println(todoList);
    }

    public List<TodoDto> readAll() {
        return todoList;
    }

    public TodoDto updateToDo(Long id) {
        return todoList
                .stream()
                .filter(todoDto -> todoDto.getId().equals(id))
                .peek(todoDto -> todoDto.setDone(true))
                .findFirst()
                .orElse(null);
    }

    public boolean deleteToDo(Long id) {
        OptionalInt idx = IntStream
                .range(0, todoList.size())
                .filter(i -> todoList.get(i).getId().equals(id))
                .findFirst();
        if (idx.isPresent()) {
            todoList.remove(idx.getAsInt());
            return true;
        }
        return false;  // Not Found
    }
}
