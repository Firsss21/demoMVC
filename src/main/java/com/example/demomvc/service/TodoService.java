package com.example.demomvc.service;

import com.example.demomvc.entity.TodoEntity;
import com.example.demomvc.entity.UserEntity;
import com.example.demomvc.model.Todo;
import com.example.demomvc.repository.TodoRepo;
import com.example.demomvc.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    private TodoRepo todoRepo;
    @Autowired
    private UserRepo userRepo;

    public Todo getOneById(Long id) {
        return Todo.toModel(todoRepo.findById(id).get());
    }

    public Todo createTodo(TodoEntity entity, Long userId) {
        UserEntity userEntity = userRepo.findById(userId).get();
        entity.setUser(userEntity);
        return Todo.toModel(todoRepo.save(entity));
    }

    public Todo completeTodo(Long id) {
        TodoEntity todoEntity = todoRepo.findById(id).get();
        todoEntity.setComplete(!todoEntity.getComplete());
        return Todo.toModel(todoRepo.save(todoEntity));
    }

    public Todo updateTodo(Todo todo) {
        System.out.println(todo);
        TodoEntity todoEntity = todoRepo.findById(todo.getId()).get();
        todoEntity.setTitle(todo.getTitle());
        return Todo.toModel(todoRepo.save(todoEntity));
    }

    public void deleteTodo(Long id) {
        todoRepo.deleteById(id);
    }

}
