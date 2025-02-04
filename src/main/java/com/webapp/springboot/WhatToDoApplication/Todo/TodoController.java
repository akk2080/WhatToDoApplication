package com.webapp.springboot.WhatToDoApplication.Todo;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

//@Controller
@SessionAttributes("name")
public class TodoController {
    private ToDoService toDoService;
    public TodoController(ToDoService toDoService){
        this.toDoService = toDoService;
    }
@RequestMapping("list-todos")
    public String ListAllTodos(ModelMap model){
        String username = getLoggedInUsername();
        List<Todo> li =  toDoService.findByUsername(username);
        model.addAttribute("todos", li);
        return "listTodos";
    }

    private String getLoggedInUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    @RequestMapping(value="add-todo", method= RequestMethod.GET)
    public String showNewTodoPage(ModelMap model){
        String username = (String)model.get("name");
        Todo todo = new Todo(0, username, "default desc", LocalDate.now().plusYears(1), false);
        model.put("todo", todo);
        return "todo";

    }

    @RequestMapping(value="add-todo", method= RequestMethod.POST)
    public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result){
        if(result.hasErrors())
                return "todo";
        String username = (String)model.get("name");
        toDoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), false);
        return "redirect:list-todos";

    }

    @RequestMapping(value="delete-todo")
    public String deleteTodo(@RequestParam int id){
        toDoService.deleteById(id);
        return "redirect:list-todos";

    }

    @RequestMapping(value="update-todo", method= RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id, ModelMap model){
        Todo todo = toDoService.findById(id);
        model.addAttribute("todo", todo);

        return "todo";

    }

    @RequestMapping(value="update-todo", method= RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result){
        if(result.hasErrors())
            return "todo";
        String username = (String)model.get("name");
        todo.setUsername(username);
        toDoService.updateTodo(todo);

        return "redirect:list-todos";

    }
    
    





}
