package com.example.careersyncapp.controller;

import com.example.careersyncapp.Constants;
import com.example.careersyncapp.model.UserT;
import com.example.careersyncapp.service.UserService;
import jakarta.websocket.OnClose;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class UserController {
@Autowired
    UserService userService;
@GetMapping("/Users")
    public ResponseEntity<Map<String,Object>> getAllUser(){
    List<UserT> allUserT = userService.getAllUser();
    return new ResponseEntity<>(Constants.createMap(allUserT),HttpStatus.OK);
}
@GetMapping("/{userId}")
    public ResponseEntity<Map<String,Object>> getUserById(@PathVariable Integer userId) {
    try {
        Optional<UserT> userById = userService.getUserById(userId);
        return new ResponseEntity<>(Constants.createMap(userById), HttpStatus.OK);
    } catch (Exception e) {
        System.out.println("Exception:" + e);
        return new ResponseEntity<>(Constants.createMap(null), HttpStatus.BAD_REQUEST);
    }
}

@PostMapping("/User")
        public ResponseEntity<Map<String,Object>> saveUser(@RequestBody UserT user){
    UserT userT = userService.saveUser(user);
    if (userT!=null){
        return new ResponseEntity<>(Constants.createMap(userT),HttpStatus.OK);
    }
    else {
        return new ResponseEntity<>(Constants.createMap(null),HttpStatus.BAD_REQUEST);
    }
}
}
