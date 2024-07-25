package com.webapp.springboot.WhatToDoApplication.Todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoService {


    private static List<Todo> todos = new ArrayList<>();
    private static int todosCount = 0;
    static{
        todos.add(new Todo(++todosCount, "akk", "spring commit", LocalDate.now().plusYears(1), false));
    }

    public List<Todo> findByUsername(String username){
        //return todos.stream().filter(x -> x.getUsername().equalsIgnoreCase(username));

        return todos;
    }


    public void addTodo(String username, String description, LocalDate localDate, boolean b) {
        Todo todo = new Todo(++todosCount, username, description, localDate, b);
        todos.add(todo);
    }
}
