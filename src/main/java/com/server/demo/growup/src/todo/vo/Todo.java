package com.server.demo.growup.src.todo.vo;

import com.server.demo.growup.src.user.vo.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Todo {

    @Id
    @Column(name = "todo_idx")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_idx")
    private User user;

    private String todoContent;
    private Timestamp createAt;
    private Boolean isComplete;

}
