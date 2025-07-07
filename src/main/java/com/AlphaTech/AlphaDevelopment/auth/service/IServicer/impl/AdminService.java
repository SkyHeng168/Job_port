package com.AlphaTech.AlphaDevelopment.auth.service.IServicer.impl;

import com.AlphaTech.AlphaDevelopment.auth.authDto.AdminDto.AdminRequest;
import com.AlphaTech.AlphaDevelopment.auth.authDto.AdminDto.AdminRespond;
import com.AlphaTech.AlphaDevelopment.auth.repository.AdminRepository;
import com.AlphaTech.AlphaDevelopment.auth.service.IServicer.IAdminService;
import com.AlphaTech.AlphaDevelopment.excption.customException.ResourceAlreadyExistsException;
import com.AlphaTech.AlphaDevelopment.excption.customException.ResourceNotFoundException;
import com.AlphaTech.AlphaDevelopment.model.Admin;
import com.AlphaTech.AlphaDevelopment.utils.JwtService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AdminService implements IAdminService {
    private final AdminRepository adminRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public List<AdminRespond> findAll() {
        List<Admin> admins = adminRepository.findAll();
        return admins.stream()
                .map(AdminRespond::convert)
                .collect(Collectors.toList());
    }

    @Override
    public AdminRespond createAdmin(AdminRequest adminRequest) {
        if (adminRepository.existsByUsernameIgnoreCase(adminRequest.username())){
            throw new ResourceAlreadyExistsException("Username already exists");
        }
        Admin admin = Admin.builder()
                .username(adminRequest.username())
                .password(encoder.encode(adminRequest.password()))
                .role(adminRequest.role())
                .build();
        Admin savedAdmin = adminRepository.save(admin);
        return AdminRespond.convert(savedAdmin);
    }

    @Override
    public AdminRespond updateAdmin(Long id, AdminRequest adminRequest) {
        Admin exitingAdmin = adminRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Admin Not Found"));
        exitingAdmin.setUsername(adminRequest.username());
        exitingAdmin.setPassword(encoder.encode(adminRequest.password()));
        exitingAdmin.setRole(adminRequest.role());
        Admin updatedAdmin = adminRepository.save(exitingAdmin);
        return AdminRespond.convert(updatedAdmin);
    }

    @Override
    public void deleteAdmin(Long id) {
        Admin findAdmin = adminRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Admin Not Found"));
        adminRepository.delete(findAdmin);
    }

    @Override
    public String verifyAdmin(AdminRequest adminRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        adminRequest.username(),
                        adminRequest.password()
                )
        );
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(adminRequest.username());
        }
        return "error login";
    }
}
