package com.example.todo.domain.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yaml.snakeyaml.events.Event;

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

    public void deleteById(long todoId){
        todoRepository.deleteById(todoId);
    }

    public void completeById(long todoId){
        todoRepository.completeById(todoId);
    }

    public void restorationById(long todoId){
        todoRepository.restorationById(todoId);
    }

    public void editById(long todoId, String summary, String description) {
        todoRepository.editById(todoId, summary, description);
    }

}
