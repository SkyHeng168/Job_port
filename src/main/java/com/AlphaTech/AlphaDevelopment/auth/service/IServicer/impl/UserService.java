package com.AlphaTech.AlphaDevelopment.auth.service.IServicer.impl;

import com.AlphaTech.AlphaDevelopment.auth.service.IServicer.IUserService;
import com.AlphaTech.AlphaDevelopment.excption.customException.ResourceAlreadyExistsException;
import com.AlphaTech.AlphaDevelopment.model.User;
import com.AlphaTech.AlphaDevelopment.auth.authDto.UserDto.UserRequest;
import com.AlphaTech.AlphaDevelopment.auth.authDto.UserDto.UserRespond;
import com.AlphaTech.AlphaDevelopment.auth.repository.UserRepository;
import com.AlphaTech.AlphaDevelopment.excption.customException.ResourceNotFoundException;
import com.AlphaTech.AlphaDevelopment.utils.FileUploadingConfig;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

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
    public UserRespond createUser(UserRequest userRequest) throws IOException{
        if (userRepository.existsByFirstNameAndLastNameIgnoreCase(userRequest.firstName(), userRequest.lastName())) {
            throw new ResourceAlreadyExistsException("User already exists");
        }
        User user = User.builder()
                .firstName(userRequest.firstName())
                .lastName(userRequest.lastName())
                .profile(SaveProfile(userRequest.profile()))
                .gender(userRequest.gender())
                .birthDate(userRequest.birthDate())
                .phoneNumber(userRequest.phoneNumber())
                .email(userRequest.email())
                .password(encoder.encode(userRequest.password()))
                .role(userRequest.role())
                .createdAt(LocalDateTime.now())
                .build();
        User savedUser = userRepository.save(user);

        return UserRespond.convertToUser(savedUser);
    }

    private String SaveProfile(MultipartFile multipartFile) throws IOException {
        return FileUploadingConfig.saveFile("uploads/user_profile", multipartFile);
    }
}
