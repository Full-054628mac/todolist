package com.example.todo.domain.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ToDoService {

    private final ToDoRepository todoRepository;

    public List<ToDoEntity> findAll() {
        return todoRepository.findAll();
    }
@Transactional
    public void create(String summary, String description){
        todoRepository.insert(summary, description);
    }

    public ToDoEntity findById(long todoId) {
        return todoRepository.findById(todoId);
    }
}

