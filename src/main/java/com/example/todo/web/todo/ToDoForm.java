package com.example.todo.web.todo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Data
public class ToDoForm {
    @NotBlank
    @Size(max=256)
    private String summary;

    @NotBlank
    @Size(max=256)
    private String description;

    private boolean isCompleted;

    public ToDoForm(String summary, String description) {
        this.summary = summary;
        this.description = description;
        this.isCompleted = false;
    }

}
