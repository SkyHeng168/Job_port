package com.AlphaTech.AlphaDevelopment.auth.controller;

import com.AlphaTech.AlphaDevelopment.auth.authDto.UserDto.UserRequest;
import com.AlphaTech.AlphaDevelopment.auth.authDto.UserDto.UserRespond;
import com.AlphaTech.AlphaDevelopment.auth.service.IServicer.impl.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth/")
public class UserController {
    private final UserService userService;


    @GetMapping
    public ResponseEntity<List<UserRespond>> getAllUser(){
        List<UserRespond> userRespondList = userService.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(userRespondList);
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> createUser (@ModelAttribute UserRequest userRequest)  {
        try {
            UserRespond user = userService.createUser(userRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(user);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
