package com.webapp.springboot.WhatToDoApplication.Todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoService {


    private static List<Todo> todos = new ArrayList<>();
    static{
        todos.add(new Todo(1, "akk", "spring commit", LocalDate.now().plusYears(1), false));
    }

    public List<Todo> findByUsername(String username){
        //return todos.stream().filter(x -> x.getUsername().equalsIgnoreCase(username));

        return todos;
    }


}
