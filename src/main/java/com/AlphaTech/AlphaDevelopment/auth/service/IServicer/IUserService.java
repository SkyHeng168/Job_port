package com.AlphaTech.AlphaDevelopment.auth.service.IServicer;

import com.AlphaTech.AlphaDevelopment.auth.authDto.UserDto.UserRequest;
import com.AlphaTech.AlphaDevelopment.auth.authDto.UserDto.UserRespond;

import java.io.IOException;
import java.util.List;

public interface IUserService {
    List<UserRespond> getAllUsers();
    UserRespond createUser(UserRequest userRequest) throws IOException;
}
