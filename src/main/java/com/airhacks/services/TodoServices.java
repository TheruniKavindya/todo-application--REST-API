package com.airhacks.services;

import com.airhacks.model.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoServices {
    List<Todo> viewAllTodos();

    Optional<Todo> viewTodoById(final int id);
    Todo createTodo(final int id, final String msg);

    boolean deleteTodo(final int id);

    Optional<Todo> updateTodo(final int id, final String msg);


}
