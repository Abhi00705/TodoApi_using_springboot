package com.example.TodoApi;

import java.util.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Todo {
        private static List<Response> todoList;
        public Todo(){
            todoList= new ArrayList<>();
            todoList.add(new Response(1, false, "gym", 11));
            todoList.add(new Response(2, false, "reading", 12));
            todoList.add(new Response(3, false, "writting", 13));

        }

        @GetMapping("/todoList")
        public List<Response> getTodo(){
            return todoList;
        }

        @PostMapping("/todos")
        public Response createTodo(@RequestBody Response newTodo){
            todoList.add(newTodo);
            return newTodo;
        }



}
