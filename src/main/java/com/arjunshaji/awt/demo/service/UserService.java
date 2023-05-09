package com.arjunshaji.awt.demo.service;

import com.arjunshaji.awt.demo.entity.Admin;
import com.arjunshaji.awt.demo.model.JWTRequest;
import com.arjunshaji.awt.demo.repository.AdminRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Slf4j
public class UserService implements UserDetailsService {

    @Autowired
    private AdminRepo adminRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("INSIDE LOAD_USER_BY_USERNAME METHOD OF USER SERVICE");
        Admin admin = adminRepo.findByUsername(username);
        if(admin != null){
            return new User(admin.getUsername(),admin.getPassword(),new ArrayList<>());
        }
        //return new User("admin","password",new ArrayList<>());
        throw new UsernameNotFoundException("USER NOT FOUND");
    }
}
