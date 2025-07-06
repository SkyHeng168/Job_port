package com.AlphaTech.AlphaDevelopment.auth.enums;

public enum AdminRole {
    SUPER_ADMIN,
    ADMIN,
    MANAGER,
    ADMINISTRATOR;

    public String getValueAdminRole() {
        return "ROLE_" + this.name();
    }
}
