package com.example.demomvc.model;

import com.example.demomvc.entity.TodoEntity;
import com.example.demomvc.entity.UserEntity;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.stream.Collectors;

public class User {
    private long id;
    private String userName;
    private String email;
    private List<Todo> todoList;

    public static User toModel(UserEntity entity){
        User user = new User();
        user.setId(entity.getId());
        user.setTodoList(entity.getTodoList().stream().map(Todo::toModel).collect(Collectors.toList()));
        user.setUserName(entity.getUserName());
        user.setEmail(entity.getEmail());
        return user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Todo> getTodoList() {
        return todoList;
    }

    public void setTodoList(List<Todo> todoList) {
        this.todoList = todoList;
    }

    public User() {
    }

}
