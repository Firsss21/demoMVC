package com.example.demomvc.repository;

import com.example.demomvc.entity.TodoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepo extends CrudRepository<TodoEntity,Long> {
}
