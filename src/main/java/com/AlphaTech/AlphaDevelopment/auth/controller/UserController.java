package com.AlphaTech.AlphaDevelopment.auth.controller;

import com.AlphaTech.AlphaDevelopment.auth.authDto.UserDto.UserRespond;
import com.AlphaTech.AlphaDevelopment.auth.service.IServicer.impl.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth/user")
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserRespond>> getAllUser(){
        List<UserRespond> userRespondList = userService.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(userRespondList);
    }

}
