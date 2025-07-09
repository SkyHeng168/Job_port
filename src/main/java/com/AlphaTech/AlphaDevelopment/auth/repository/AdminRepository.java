package com.AlphaTech.AlphaDevelopment.auth.repository;

import com.AlphaTech.AlphaDevelopment.auth.enums.AdminRole;
import com.AlphaTech.AlphaDevelopment.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByUsername(String username);
    boolean existsByUsernameIgnoreCase(String username);
    Admin findByUsernameIgnoreCase(String username);

    Optional<Admin> findByRole(AdminRole adminRole);
}
