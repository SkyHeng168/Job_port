package com.AlphaTech.AlphaDevelopment.utils;

import com.AlphaTech.AlphaDevelopment.auth.enums.AdminRole;
import com.AlphaTech.AlphaDevelopment.model.Admin;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UserPrincipal implements UserDetails {
    private final Admin admin;
    private final AdminRole adminRole;
    public UserPrincipal(Admin admin,  AdminRole adminRole) {
        this.admin = admin;
        this.adminRole = adminRole;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(
                new SimpleGrantedAuthority("ROLE_" + adminRole.getValueAdminRole())
        );
    }

    @Override
    public String getPassword() {
        return admin.getPassword();
    }

    @Override
    public String getUsername() {
        return admin.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
