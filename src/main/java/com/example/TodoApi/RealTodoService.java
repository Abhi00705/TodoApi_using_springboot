package com.example.TodoApi;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("RealTodoService")
public class RealTodoService implements TodoService{

    @Override
    public String doSomething() {
        return "real todo!";
    }
}
