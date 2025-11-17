package com.example.TodoApi;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Todo {
        private static List<Response> todoList;
        public Todo(){
            todoList= new ArrayList<>();
            todoList.add(new Response(1, false, "gym", 11));
            todoList.add(new Response(2, false, "reading", 12));
            todoList.add(new Response(3, false, "writting", 13));

        }
        //ResponseEntity: it is a class that help to return manual response like ResponseEntity.Status(HttpStatus.ok)
// Getting data from "todoList"
        @GetMapping("/todoList")
        public ResponseEntity<List<Response>> getTodo(){
            return ResponseEntity.ok(todoList);
        }
// Getting data form user and set it in the "todoList"
        @PostMapping("/todos")
        public ResponseEntity <Response> createTodo(@RequestBody Response newTodo){
            todoList.add(newTodo);
            return ResponseEntity.status(HttpStatus.CREATED).body(newTodo);
        }

        //---------------- Variable URL ----------------------

    @GetMapping("/todoList/{todoId}")
    public ResponseEntity <Response> getTodoById(@PathVariable Long todoId){
            for(Response todo : todoList){
                if(todo.getId() == todoId){
                    return ResponseEntity.ok(todo);
                }

            }
            return ResponseEntity.notFound().build();
    }




}
