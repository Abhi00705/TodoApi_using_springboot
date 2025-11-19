package com.example.TodoApi;

import org.springframework.stereotype.Service;

@Service("FakeTodoService")
public class FakeTodoService implements TodoService {
    @TimeMonitor
    public String doSomething(){
        for(int i=1;i<1000000000;i++){

        }
        return "something";
    }

}
