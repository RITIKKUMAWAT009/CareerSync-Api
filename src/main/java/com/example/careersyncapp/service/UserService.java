package com.example.careersyncapp.service;

import com.example.careersyncapp.model.UserT;
import com.example.careersyncapp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

  public   List<UserT> getAllUser(){
        return userRepo.findAll();
    }
    public  Optional<UserT> getUserById(Integer userId){
        return userRepo.findById(userId);
    }

    public  UserT  saveUser(UserT user){
        UserT save = userRepo.save(user);
        return save;
    }
}
