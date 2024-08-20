package com.server.demo.growup.src.todo.controller;

import com.server.demo.growup.global.response.BaseResponse;
import com.server.demo.growup.global.response.BaseStatus;
import com.server.demo.growup.src.todo.service.TodoService;
import com.server.demo.growup.src.todo.vo.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todo")
public class TodoController {

    private final TodoService todoService;
    
    @GetMapping("/{todoId}")
    public BaseResponse<List<Todo>> getTodoByUserUuid(String userUuid) {
        List<Todo> todos = todoService.getTodoByUserUuid(userUuid);
        return new BaseResponse<>(todos);
    }
}
