package com.webapp.springboot.WhatToDoApplication.Todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoController {
    private ToDoService toDoService;
    public TodoController(ToDoService toDoService){
        this.toDoService = toDoService;
    }
@RequestMapping("list-todos")
    public String ListAllTodos(ModelMap model){
        List<Todo> li =  toDoService.findByUsername("akk");
        model.addAttribute("todos", li);
        return "listTodos";
    }


}
