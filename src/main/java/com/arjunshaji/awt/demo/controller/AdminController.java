package com.arjunshaji.awt.demo.controller;

import com.arjunshaji.awt.demo.entity.Admin;
import com.arjunshaji.awt.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/signup")
    private Object signupAdmin(@RequestBody Admin admin){
        adminService.signupAdmin(admin);
        return "ADMIN REGISTERED SUCCESSFUL.........";
    }

    @GetMapping("/get/{id}")
    private Object getAdminById(@PathVariable Long id){
        return adminService.getAdminById(id);
    }
}
