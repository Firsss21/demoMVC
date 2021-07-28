package com.example.demomvc.entity;

import com.example.demomvc.model.Todo;
import com.example.demomvc.validators.UniqueUser;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull(message = "user name should be no null")
    @Size(min = 3, max = 25, message = "username should be in range 3:25")
    private String userName;
    @Size(min = 4, max = 30, message = "email should be in range 4:30")
    private String password;
    @Size(min = 8, max = 40, message = "password should be in range 8:40")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<TodoEntity> todoList = new ArrayList<>();

    public UserEntity() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<TodoEntity> getTodoList() {
        return todoList;
    }

    public void setTodoList(List<TodoEntity> todoList) {
        this.todoList = todoList;
    }
}
