package com.server.demo.growup.src.todo.service;

import com.server.demo.growup.global.exception.BaseException;
import com.server.demo.growup.global.response.BaseStatus;
import com.server.demo.growup.src.todo.dao.TodoRepository;
import com.server.demo.growup.src.todo.vo.Todo;
import com.server.demo.growup.src.user.dao.UserRepository;
import com.server.demo.growup.src.user.vo.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    public List<Todo> getTodoByUserUuid(String userUuid) {
        User user = userRepository.findByUserUuid(userUuid)
                .orElseThrow(() -> new BaseException(BaseStatus.NOT_FOUND_USER));

        List<Todo> todos = todoRepository.findByUser(user)
                .orElse(null);

        return todos;
    }
}
