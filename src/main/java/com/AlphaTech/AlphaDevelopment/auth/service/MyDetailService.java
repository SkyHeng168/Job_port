package com.AlphaTech.AlphaDevelopment.auth.service;

import com.AlphaTech.AlphaDevelopment.auth.enums.AdminRole;
import com.AlphaTech.AlphaDevelopment.auth.repository.AdminRepository;
import com.AlphaTech.AlphaDevelopment.model.Admin;
import com.AlphaTech.AlphaDevelopment.utils.UserPrincipal;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class MyDetailService implements UserDetailsService {
    private final AdminRepository adminRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminRepository.findByUsername(username);
        if (admin == null) {
            System.out.println("Admin Not Found");
            throw new UsernameNotFoundException("Admin Not Found");
        }
        AdminRole adminRole = admin.getRole();
        return new UserPrincipal(admin, adminRole);
    }
}
