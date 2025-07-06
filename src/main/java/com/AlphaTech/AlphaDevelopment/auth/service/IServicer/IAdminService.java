package com.AlphaTech.AlphaDevelopment.auth.service.IServicer;

import com.AlphaTech.AlphaDevelopment.auth.authDto.AdminDto.AdminRequest;
import com.AlphaTech.AlphaDevelopment.auth.authDto.AdminDto.AdminRespond;

import java.util.List;

public interface IAdminService {
    List<AdminRespond> findAll();
    AdminRespond createAdmin(AdminRequest adminRequest);
    AdminRespond updateAdmin(Long id, AdminRequest adminRequest);
    void deleteAdmin(Long id);
}
