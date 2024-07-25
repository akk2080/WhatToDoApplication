package com.webapp.springboot.WhatToDoApplication.Todo;

import jakarta.validation.Valid;
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
        todos.add(new Todo(++todosCount, "akk", "spring commit2", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todosCount, "akk", "spring commit3", LocalDate.now().plusYears(1), false));
    }

    public List<Todo> findByUsername(String username){
        //return todos.stream().filter(x -> x.getUsername().equalsIgnoreCase(username));

        return todos;
    }


    public void addTodo(String username, String description, LocalDate localDate, boolean b) {
        Todo todo = new Todo(++todosCount, username, description, localDate, b);
        todos.add(todo);
    }

    public void deleteById(int id){
        todos.removeIf(x -> x.getId()== id);
    }

    public Todo findById(int id){
        Todo todo = todos.stream().filter(x -> x.getId()== id).findFirst().get();
        return todo;
    }

    public void updateTodo(@Valid Todo todo){

        deleteById(todo.getId());

        todos.add(todo);
    }
}
