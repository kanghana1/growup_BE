package com.server.demo.growup.src.todo.dao;

import com.server.demo.growup.src.todo.vo.Todo;
import com.server.demo.growup.src.user.vo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    Optional<Todo> findById(Long id);
    Optional<List<Todo>> findByUser(User user);
    List<Todo> findByUserAndCreateAtBetween(User user, LocalDateTime startDay, LocalDateTime endDay);

}
