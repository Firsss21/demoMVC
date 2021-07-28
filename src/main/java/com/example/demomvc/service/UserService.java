package com.example.demomvc.service;

import com.example.demomvc.entity.UserEntity;
import com.example.demomvc.exception.UserNotExist;
import com.example.demomvc.model.User;
import com.example.demomvc.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public List<User> getAll() {
        List<User> users = new ArrayList<User>();
        userRepo.findAll().forEach(e -> users.add(User.toModel(e)));
        return users;
    }
    public User getOne(Long id)  {
        UserEntity user = userRepo.findById(id).get();
        return User.toModel(user);
    }

    public boolean userNameNotExists(String name) {
        UserEntity user = userRepo.findByUserName(name);
        if (user != null)
            return false;
        else
            return true;
    }

    public Long delete(Long id) {
        userRepo.deleteById(id);
        return id;
    }

    public User registration(UserEntity user) {
        return User.toModel(userRepo.save(user));
    }

    public User updateUser(Long id, User user) {
        UserEntity userEntity = userRepo.findById(id).get();
        userEntity.setId(user.getId());
        userEntity.setUserName(user.getUserName());
        userEntity.setEmail(user.getEmail());
        return User.toModel(userRepo.save(userEntity));
    }
}
