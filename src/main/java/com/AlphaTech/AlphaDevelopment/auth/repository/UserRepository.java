package com.AlphaTech.AlphaDevelopment.auth.repository;

import com.AlphaTech.AlphaDevelopment.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByFirstNameAndLastNameIgnoreCase(String firstName, String lastName);
}
