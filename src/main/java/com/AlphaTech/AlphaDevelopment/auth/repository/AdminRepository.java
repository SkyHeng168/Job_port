package com.AlphaTech.AlphaDevelopment.auth.repository;

import com.AlphaTech.AlphaDevelopment.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByUsername(String username);
    boolean existsByUsernameIgnoreCase(String username);
}
