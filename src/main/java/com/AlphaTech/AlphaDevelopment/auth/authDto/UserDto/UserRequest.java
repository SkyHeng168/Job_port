package com.AlphaTech.AlphaDevelopment.auth.authDto.UserDto;

import com.AlphaTech.AlphaDevelopment.auth.enums.Gender;
import com.AlphaTech.AlphaDevelopment.auth.enums.UserRole;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record UserRequest(
        Long id,
        String firstName,
        String lastName,
        MultipartFile profile,
        Gender gender,
        LocalDate birthDate,
        String phoneNumber,
        String email,
        String password,
        UserRole role,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
