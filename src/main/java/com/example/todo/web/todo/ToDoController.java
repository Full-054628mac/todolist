package com.example.todo.web.todo;

import com.example.todo.domain.todo.ToDoEntity;
import com.example.todo.domain.todo.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.lang.*;

@Controller
@RequestMapping("/todos")
@RequiredArgsConstructor
public class ToDoController {

    private final ToDoService todoService;

    @GetMapping
    public String showList(Model model){

        var allDataList = todoService.findAll();
        var completedList = new ArrayList<ToDoEntity>();
        var noCompletedList = new ArrayList<ToDoEntity>();

        allDataList.forEach(data->{
            if (data.isCompleted()){
                completedList.add(data);
            }else{
                noCompletedList.add(data);
            }
        });
        model.addAttribute("completedList", completedList);
        model.addAttribute("noCompletedList", noCompletedList);
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

    @PostMapping("/delete")
    public String delete (@RequestParam("index") long index){
        todoService.deleteById(index);
        return "redirect:/todos";
    }

    @PostMapping("/complete")
    public String complete (@RequestParam("index") long index){
        todoService.completeById(index);
        return "redirect:/todos";
    }

    @PostMapping("/restoration")
    public String restoration (@RequestParam("index") long index){
        todoService.restorationById(index);
        return "redirect:/todos";
    }

    @GetMapping("/editForm/{todoId}")
    public String showEditForm(@PathVariable("todoId") long todoId, Model model) {
        ToDoEntity todoEntity = todoService.findById(todoId);
        ToDoForm toDoForm = new ToDoForm(todoEntity.getSummary(), todoEntity.getDescription());
        model.addAttribute("toDoForm", toDoForm);
        model.addAttribute("todoId", todoId);
        return "todos/editForm";
    }

    @PostMapping("/edit/{todoId}")
    public String edit(@PathVariable("todoId") long todoId, @Validated ToDoForm form, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "todos/editForm";
        }
        todoService.editById(todoId, form.getSummary(), form.getDescription());
        return "redirect:/todos";
    }

}
