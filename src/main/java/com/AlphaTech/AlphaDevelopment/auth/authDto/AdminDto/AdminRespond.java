package com.AlphaTech.AlphaDevelopment.auth.authDto.AdminDto;

import com.AlphaTech.AlphaDevelopment.auth.enums.AdminRole;
import com.AlphaTech.AlphaDevelopment.model.Admin;

public record AdminRespond (
        String username,
        AdminRole role
){
    public static AdminRespond convert(Admin admin){
        return new AdminRespond(
                admin.getUsername(),
                admin.getRole()
        );
    }
}
