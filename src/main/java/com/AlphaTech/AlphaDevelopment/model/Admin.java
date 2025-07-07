package com.AlphaTech.AlphaDevelopment.model;

import com.AlphaTech.AlphaDevelopment.auth.enums.AdminRole;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "admin_tbl")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100,  nullable = false, unique = true)
    private String username;

    @Column(length = 1000,  nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private AdminRole role;
}
