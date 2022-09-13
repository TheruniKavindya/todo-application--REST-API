package com.airhacks.services;

import com.airhacks.model.Todo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TodoServiceImpl implements TodoServices{

    private static List<Todo> todos = new ArrayList<>();

    @Override
    public List<Todo> viewAllTodos() {
        return todos;
    }

    @Override
    public Optional<Todo> viewTodoById(int id) {
        for(Todo todo: todos){
            if(todo.getId()==id){
                return Optional.of(todo);
            }
        }
        return Optional.empty();
    }

    @Override
    public Todo createTodo(int id, String msg) {
        String now = LocalDateTime.now().toString();
        Todo todo = new Todo(id, msg, now);
        todos.add(todo);
        return todo;
    }

    @Override
    public boolean deleteTodo(int id) {
        for(Todo tempTodo:todos){
            if(tempTodo.getId()==id){
                todos.remove(tempTodo);
                return true;
            }
        }
        return false;
    }

    @Override
    public Optional<Todo> updateTodo(int id, String msg){
        String now = LocalDateTime.now().toString();
        Todo todo = new Todo(id, msg, now);
        for(Todo tempTodo:todos){
            if(tempTodo.getId()==todo.getId()){
                tempTodo.setMsg(todo.getMsg());
                tempTodo.setCreatedAt(todo.getCreatedAt());
                return Optional.of(tempTodo);
            }
        }
        return Optional.empty();
    }
}
