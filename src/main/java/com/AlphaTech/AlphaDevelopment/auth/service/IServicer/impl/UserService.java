package com.AlphaTech.AlphaDevelopment.auth.service.IServicer.impl;

import com.AlphaTech.AlphaDevelopment.auth.service.IServicer.IUserService;
import com.AlphaTech.AlphaDevelopment.model.User;
import com.AlphaTech.AlphaDevelopment.auth.authDto.UserDto.UserRequest;
import com.AlphaTech.AlphaDevelopment.auth.authDto.UserDto.UserRespond;
import com.AlphaTech.AlphaDevelopment.auth.repository.UserRepository;
import com.AlphaTech.AlphaDevelopment.excption.customException.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;

    @Override
    public List<UserRespond> getAllUsers() {
        List<User> listUsers = userRepository.findAll();
        if (listUsers.isEmpty()) {
            throw new ResourceNotFoundException("User not found");
        }
        return listUsers.stream()
                .map(UserRespond::convertToUser)
                .collect(Collectors.toList());
    }

    @Override
    public UserRespond createUser(UserRequest userRequest) {
        return null;
    }
}
