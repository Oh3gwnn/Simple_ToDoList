package com.my.ToDoList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("/todo")
    public String todo(Model model) {
        List<TodoDto> todoDtoList = this.todoService.readAll();
        model.addAttribute("todoList", todoDtoList);
        return "todo";
    }

    @RequestMapping("/")
    public String home() {
        return "redirect:/todo";
    }

    @PostMapping("/todo/create")
    public String create(
            @RequestParam("todo-desc") String content) {
        // 새로운 TODO를 생성하는 컨트롤러 메소드
        todoService.createToDo(content);
        return "redirect:/todo";
    }

    public String update() {
        // TODO의 done 상태를 변경하는 메소드
        throw new RuntimeException("TODO");
    }

    public String delete() {
        // TODO를 삭제하는 메소드
        throw new RuntimeException("TODO");
    }
}
