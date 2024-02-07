package com.example.careersyncapp.controller;
import com.example.careersyncapp.Constants;
import com.example.careersyncapp.model.LoginAuth;
import com.example.careersyncapp.model.UserT;
import com.example.careersyncapp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@RestController
public class AuthController {
    @Autowired
    UserRepo userRepo;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserT userT) {
        if (userRepo.findByUserName(userT.getUserName()).isPresent()) {
            return  new ResponseEntity<>(Constants.ALREADY_TAKEN,HttpStatus.BAD_REQUEST);
        }
        userRepo.save(userT);
        return  new ResponseEntity<>(Constants.CREATED_SUCCESS,HttpStatus.OK);
    }

    @PostMapping("/login")
public ResponseEntity<String> login(@RequestBody LoginAuth loginUser) {
        Optional<UserT> byUserName = userRepo.findByUserName(loginUser.getUserName());
        if (byUserName.isPresent() && byUserName.get().getPassword().equals(loginUser.getPassword())) {
         return  new ResponseEntity<>(Constants.SUCCESS,HttpStatus.OK);
        } else {
            return  new ResponseEntity<>(Constants.FAILURE,HttpStatus.BAD_REQUEST);
        }
    }
}