package com.airhacks.controller;

import com.airhacks.dto.CreateTodoDto;
import com.airhacks.model.Todo;
import com.airhacks.services.TodoServices;
import com.google.gson.Gson;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("todos")
public class TodoController {
    @Inject
    private TodoServices todoService;

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAllTodos(){
        return Response.ok(new Gson().toJson(todoService.viewAllTodos()), MediaType.APPLICATION_JSON).build();
    }

    @GET()
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getTodoById(@PathParam("id") Integer id){
        if(todoService.viewTodoById(id).isPresent()){
            return Response.ok(new Gson().toJson(todoService.viewTodoById(id).get()), MediaType.APPLICATION_JSON).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addTodo(CreateTodoDto todoDto){
        Todo newTodo = todoService.createTodo(todoDto.getId(),todoDto.getMsg());
        return Response.ok(new Gson().toJson(newTodo), MediaType.APPLICATION_JSON).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteTodo(@PathParam("id") Integer id){
        if(todoService.deleteTodo(id))   {
            return Response.status(Response.Status.ACCEPTED).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Path("{id}")
    public Response updateTodo(@PathParam("id") Integer id){
        Optional<Todo> tempTodo = todoService.updateTodo(id, "todo2");
        if(tempTodo.isPresent()){
            return Response.status(Response.Status.ACCEPTED).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

}
