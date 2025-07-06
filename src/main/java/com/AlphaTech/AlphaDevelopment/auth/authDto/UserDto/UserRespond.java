package com.AlphaTech.AlphaDevelopment.auth.authDto.UserDto;

import com.AlphaTech.AlphaDevelopment.model.User;
import com.AlphaTech.AlphaDevelopment.auth.enums.Gender;
import com.AlphaTech.AlphaDevelopment.auth.enums.UserRole;

import java.time.format.DateTimeFormatter;

public record UserRespond(
        Long id,
        String firstName,
        String lastName,
        String profile,
        Gender gender,
        String birthDate,
        String phoneNumber,
        String email,
        UserRole role,
        String createdAt,
        String updatedAt
) {
    public static UserRespond convertToUser(User user) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd HH:mm:ss a");
        return new UserRespond(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getProfile(),
                user.getGender(),
                user.getBirthDate() != null ? user.getBirthDate().toString() : null,
                user.getPhoneNumber(),
                user.getEmail(),
                user.getRole(),
                user.getCreatedAt() != null ? formatter.format(user.getCreatedAt()) : null,
                user.getUpdatedAt() != null ? formatter.format(user.getUpdatedAt()) : null
        );
    }
}
