package com.server.demo.growup.src.todo.vo;

import com.server.demo.growup.src.user.vo.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Todo {

    @Id
    @Column(name = "todo_idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_idx")
    private User user;

    private String todoContent;

    @Column(name = "create_at", updatable = false)
    private LocalDateTime createAt;

    private Boolean isComplete;

    public void setTodoContent(String content) {
        this.todoContent = content;
    }

    // 이게 필요할까
    public void setUser(User user) {
        this.user = user;
    }

    public void setIsComplete(Boolean isComplete) {
        this.isComplete = isComplete;
    }
}
