package com.example.demomvc.model;

import com.example.demomvc.entity.TodoEntity;
import com.example.demomvc.entity.UserEntity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Todo {
    private long id;
    private String title;
    private Boolean complete;
    private UserEntity user;

    public static Todo toModel(TodoEntity todoEntity) {
        Todo todo = new Todo();
        todo.setId(todoEntity.getId());
        todo.setComplete(todoEntity.getComplete());
        todo.setUser(todoEntity.getUser());
        todo.setTitle(todoEntity.getTitle());
        return todo;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    public UserEntity getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", complete=" + complete +
                ", user=" + user +
                '}';
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
