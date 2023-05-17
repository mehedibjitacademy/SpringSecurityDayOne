package com.example.springsecurityauthandjwt.service.impl;


import com.example.springsecurityauthandjwt.entity.UserEntity;
import com.example.springsecurityauthandjwt.model.ResponseModel;
import com.example.springsecurityauthandjwt.model.UserRequestModel;
import com.example.springsecurityauthandjwt.repository.UserRepository;
import com.example.springsecurityauthandjwt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        return null;
    }

    @Override
    public ResponseEntity<Object> register(UserRequestModel requestModel) {
        UserEntity userEntity = UserEntity.builder()
                .email(requestModel.getEmail())
                .userName(requestModel.getUserName())
                .firstName(requestModel.getFirstName())
                .lastName(requestModel.getLastName())
                .password(requestModel.getPassword())
                .build();
        UserEntity savedUserEntity = userRepository.save(userEntity);
        ResponseModel responseModel= ResponseModel.builder()
                .email(savedUserEntity.getEmail())
                .userName(savedUserEntity.getUserName())
                .firstName(savedUserEntity.getFirstName())
                //.lastName(savedUserEntity.getLastName())
                .build();
        return new ResponseEntity<>(responseModel, HttpStatus.CREATED);
    }
}
