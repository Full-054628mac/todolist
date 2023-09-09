package com.example.todo.web.todo;

import com.example.todo.domain.todo.ToDoEntity;
import com.example.todo.domain.todo.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/todos")
@RequiredArgsConstructor
public class ToDoController {

    private final ToDoService todoService;

    @GetMapping
    public String showList(Model model){
        model.addAttribute("todoList",todoService.findAll());
        return "todos/list";
    }

    @GetMapping("/creationForm")
    public String showCreationForm(@ModelAttribute ToDoForm form){
        return "todos/creationForm";
    }

    @PostMapping
    public String create(@Validated ToDoForm form, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return showCreationForm(form);
        }
        todoService.create(form.getSummary(),form.getDescription());
        return "redirect:/todos";
    }

    @GetMapping("/{todoId}")
    public String showDetail(@PathVariable("todoId") long todoId, Model model) {
        model.addAttribute("todo", todoService.findById(todoId));
        return "todos/detail";
    }
}
