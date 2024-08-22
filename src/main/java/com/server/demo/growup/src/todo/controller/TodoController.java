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

    @PostMapping
    public BaseResponse<Todo> saveTodo(@RequestParam String userUuid, @RequestParam String content) {
        todoService.saveTodo(userUuid, content);
        return new BaseResponse<>(BaseStatus.SUCCESS);
    }
    
    @GetMapping("/{todoId}")
    public BaseResponse<List<Todo>> getTodosByCreateAt(@RequestParam("userId") Long userId,
                                                       @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<Todo> todos = todoService.getTodoByUserAndCreateAt(userId, date);
        return new BaseResponse<>(todos);
    }

    @PatchMapping("/{todoId}/status")
    public BaseResponse<Todo> updateTodoStatus(@PathVariable Long todoId, @RequestBody Boolean isComplete) {
        Todo todo = todoService.updateTodoStatus(todoId, isComplete);
        return new BaseResponse<>(todo);
    }

    @PutMapping("/{todoId}/content")
    public BaseResponse<Todo> updateTodoContent(@PathVariable Long todoId, @RequestBody String newContent) {
        Todo todo = todoService.updateTodoContent(todoId, newContent);
        return new BaseResponse<>(todo);
    }

    @DeleteMapping("/{todoId}")
    public BaseResponse<Todo> deleteTodo(@PathVariable Long todoId) {
        todoService.deleteTodoById(todoId);
        return new BaseResponse<>(BaseStatus.SUCCESS);
    }


}
