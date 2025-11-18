package com.example.TodoApi;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/todo") //this is parent URL
public class Todo {
        private static List<Response> todoList;
        public Todo(){
            todoList= new ArrayList<>();
            todoList.add(new Response(1l, false, "gym", 11l));
            todoList.add(new Response(2l, false, "reading", 12l));
            todoList.add(new Response(3l, false, "writting", 13l));

        }
        //ResponseEntity: it is a class that help to return manual response like ResponseEntity.Status(HttpStatus.ok)
// Getting data from "todoList"
        @GetMapping
        public ResponseEntity<List<Response>> getTodo(@RequestParam(required = false ,defaultValue="true") boolean completed){
            System.out.println("isCompleted: " + completed);
            return ResponseEntity.ok(todoList);
        }
// Getting data form user and set it in the "todoList"
        @PostMapping
        public ResponseEntity <Response> createTodo(@RequestBody Response newTodo){
            todoList.add(newTodo);
            return ResponseEntity.status(HttpStatus.CREATED).body(newTodo);
        }

        //---------------- Variable URL ----------------------
// H/W try to return JSON like{ message: data not avilable} when data not found
        @GetMapping("/{todoId}")
        public ResponseEntity <?> getTodoById(@PathVariable Long todoId ){

            for(Response todo : todoList){
                if(todo.getId().equals(todoId)){
                    return ResponseEntity.ok(todo);
                }

            }

        ErrorResponse error = new ErrorResponse("data not available");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

        @DeleteMapping("/{todoId}")
        public ResponseEntity<ErrorResponse> DeleteTodo(@PathVariable Long todoId){
            ErrorResponse status = new ErrorResponse();
            for(Response todo : todoList){
                if(todo.getId().equals(todoId)){
                    todoList.remove(todo);
                    status.setMessage("data deleted!");
                    return ResponseEntity.ok(status);
                }
            }
            status.setMessage("data not found!");
            return ResponseEntity.status(HttpStatus.OK).body(status);
        }

        @PatchMapping("/{todoId}")
        public ResponseEntity<ErrorResponse> patchTodo(@PathVariable Long todoId, @RequestBody Response updateTodo){
            for(Response todo : todoList){
                if(todo.getId().equals(todoId)){

                      if(updateTodo.getUserId() != null){
                          todo.setUserId(updateTodo.getUserId());
                      }
                      if(updateTodo.getTitle() != null){
                          todo.setTitle(updateTodo.getTitle());
                      }
                      if(updateTodo.isCompleted() != null){
                          todo.setCompleted(updateTodo.isCompleted());
                      }


                }
            }
            ErrorResponse stat = new ErrorResponse();
            stat.setMessage("updated sucessfully!");
            return ResponseEntity.ok(stat);

        }



}
