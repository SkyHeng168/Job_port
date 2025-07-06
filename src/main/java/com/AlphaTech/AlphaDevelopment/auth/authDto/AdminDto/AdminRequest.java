package com.AlphaTech.AlphaDevelopment.auth.authDto.AdminDto;

import com.AlphaTech.AlphaDevelopment.auth.enums.AdminRole;

public record AdminRequest(
        String username,
        String password,
        AdminRole role
) {
}
