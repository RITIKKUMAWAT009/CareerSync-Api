package com.example.careersyncapp.repository;

import com.example.careersyncapp.model.UserT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UserT,Integer> {
    Optional<UserT> findByUserName(String userName);
}
