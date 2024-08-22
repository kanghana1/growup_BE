package com.server.demo.growup.src.todo.service;

import com.server.demo.growup.global.exception.BaseException;
import com.server.demo.growup.global.response.BaseStatus;
import com.server.demo.growup.src.todo.dao.TodoRepository;
import com.server.demo.growup.src.todo.vo.Todo;
import com.server.demo.growup.src.user.dao.UserRepository;
import com.server.demo.growup.src.user.service.UserService;
import com.server.demo.growup.src.user.vo.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;
    private final UserService userService;

    public List<Todo> getTodoByUserUuid(String userUuid) {
        User user = userService.getUserByUserUuid(userUuid);
        List<Todo> todos = todoRepository.findByUser(user)
                .orElse(null);

        return todos;
    }

    public Todo getTodoById(Long todoId) {
        Todo todo = todoRepository.findById(todoId)
                .orElseThrow(() -> new BaseException(BaseStatus.NOT_FOUND_TODO));

        return todo;
    }

    public List<Todo> getTodoByUserAndCreateAt(Long userId, LocalDate date) {
        User user = userService.getUserByUserId(userId); // 나중에 uuid로 변경

        // 선택된 날짜의 시작, 끝지점 설정 (00:00:00 / 23:59:59) -> LocalDateTime이용
        LocalDateTime startDay = date.atStartOfDay();
        LocalDateTime endDay = date.atTime(LocalTime.MAX);

        return todoRepository.findByUserAndCreateAtBetween(user, startDay, endDay);
    }

    public void saveTodo(String userUuid, String content) {
        User user = userService.getUserByUserUuid(userUuid);

        Todo todo = new Todo();
        todo.setTodoContent(content);
        todo.setUser(user);

        todoRepository.save(todo);
    }

    public Todo updateTodoContent(Long todoId, String newContent) {
        Todo todo = getTodoById(todoId);

        todo.setTodoContent(newContent);
        todoRepository.save(todo);

        return todo;
    }

    public Todo updateTodoStatus(Long todoId, Boolean isComplete) {
        Todo todo = getTodoById(todoId);

        todo.setIsComplete(isComplete);
        todoRepository.save(todo);

        return todo;
    }

    public void deleteTodoById(Long todoId) {
        Todo todo = getTodoById(todoId);
        todoRepository.delete(todo);
    }


}
