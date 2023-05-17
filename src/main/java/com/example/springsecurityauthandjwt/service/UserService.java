package com.example.springsecurityauthandjwt.service;


import com.example.springsecurityauthandjwt.model.UserRequestModel;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<Object> register(UserRequestModel requestModel);
}
