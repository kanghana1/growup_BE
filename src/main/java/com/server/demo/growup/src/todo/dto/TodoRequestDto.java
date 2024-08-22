package com.server.demo.growup.src.todo.dto;

import lombok.Builder;
import lombok.Data;

public class TodoRequestDto {

    @Data
    @Builder
    public static class SaveTodoDto {
        private String todoContent;
    }
}
