package com.example.TodoApi;

import org.springframework.stereotype.Service;

@Service("FakeTodoService")
public class FakeTodoService implements TodoService {
    public String doSomething(){

        return "something";
    }

}
