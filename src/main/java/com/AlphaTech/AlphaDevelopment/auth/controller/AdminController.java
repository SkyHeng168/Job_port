package com.AlphaTech.AlphaDevelopment.auth.controller;

import com.AlphaTech.AlphaDevelopment.auth.authDto.AdminDto.AdminRequest;
import com.AlphaTech.AlphaDevelopment.auth.authDto.AdminDto.AdminRespond;
import com.AlphaTech.AlphaDevelopment.auth.service.IServicer.impl.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/private/auth")
public class AdminController {
    private final AdminService adminService;

    @GetMapping
    public ResponseEntity<List<AdminRespond>> getAllAdmins() {
        List<AdminRespond> adminRespondList = adminService.findAll();
        return new ResponseEntity<>(adminRespondList, HttpStatus.OK);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<AdminRespond> getAdminByUsername(@PathVariable String username) {
        AdminRespond adminRespond = adminService.getAdminByUsername(username);
        return ResponseEntity.status(HttpStatus.OK).body(adminRespond);
    }

    @GetMapping("/role/{role}")
    public ResponseEntity<AdminRespond> getAdminByRoleIgnoreCase(@PathVariable String role) {
        AdminRespond adminRespond = adminService.getAdminByRole(role);
        return ResponseEntity.status(HttpStatus.OK).body(adminRespond);
    }

    @PostMapping
    public ResponseEntity<AdminRespond> insertAdmin(@RequestBody AdminRequest adminRequest) {
        AdminRespond adminRespond = adminService.createAdmin(adminRequest);
        return ResponseEntity.status(HttpStatus.OK).body(adminRespond);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdminRespond> updateAdmin(@PathVariable Long id, @RequestBody AdminRequest adminRequest) {
        AdminRespond adminRespond = adminService.updateAdmin(id, adminRequest);
        return ResponseEntity.status(HttpStatus.OK).body(adminRespond);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AdminRespond> deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdminRespond> getAdminById(@PathVariable Long id) {
        AdminRespond adminRespond = adminService.getAdmin(id);
        return ResponseEntity.status(HttpStatus.OK).body(adminRespond);
    }
}
