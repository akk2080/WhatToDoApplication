package com.webapp.springboot.WhatToDoApplication.Todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
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

    @RequestMapping(value="add-todo", method= RequestMethod.GET)
    public String showNewTodoPage(){
        return "todo";

    }

    @RequestMapping(value="add-todo", method= RequestMethod.POST)
    public String showNewTodoPage(@RequestParam String description, ModelMap model){
        String username = (String)model.get("name");
        toDoService.addTodo(username, description, LocalDate.now().plusYears(1), false);
        return "todo";

    }


}
