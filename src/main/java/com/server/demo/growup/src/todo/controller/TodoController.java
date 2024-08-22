package com.server.demo.growup.src.todo.controller;

import com.server.demo.growup.global.response.BaseResponse;
import com.server.demo.growup.global.response.BaseStatus;
import com.server.demo.growup.src.todo.dto.TodoRequestDto;
import com.server.demo.growup.src.todo.service.TodoService;
import com.server.demo.growup.src.todo.vo.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static com.server.demo.growup.src.todo.dto.TodoRequestDto.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todo")
public class TodoController {

    private final TodoService todoService;
    
    @GetMapping("/{todoId}")
    public BaseResponse<List<Todo>> getTodosByCreateAt(@RequestParam("userId") Long userId,
                                                       @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<Todo> todos = todoService.getTodoByUserAndCreateAt(userId, date);
        return new BaseResponse<>(todos);
    }

    @PostMapping
    public BaseResponse<Todo> saveTodo(@RequestParam String userUuid, @RequestParam String content) {
        todoService.saveTodo(userUuid, content);
        return new BaseResponse<>(BaseStatus.SUCCESS);
    }
}
