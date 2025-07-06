package com.AlphaTech.AlphaDevelopment.auth.enums;

public enum UserRole {
    SEEKER,
    RECRUITMENT;
    public String getUserRoleName(){
        return "ROLE_" + this.name();
    }
}
