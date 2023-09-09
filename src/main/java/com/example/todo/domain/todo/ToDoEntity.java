package com.example.todo.domain.todo;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ToDoEntity {
    private long id;
    private String summary;
    private String description;
}
