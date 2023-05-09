package com.arjunshaji.awt.demo.service;

import com.arjunshaji.awt.demo.entity.Admin;
import com.arjunshaji.awt.demo.repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AdminRepo adminRepo;

    public void signupAdmin(Admin admin) {
        String bcryptPassword = passwordEncoder.encode(admin.getPassword());
        admin.setPassword(bcryptPassword);
        adminRepo.save(admin);
    }

    public Object getAdminById(Long id) {
        return adminRepo.findById(id);
    }
}
