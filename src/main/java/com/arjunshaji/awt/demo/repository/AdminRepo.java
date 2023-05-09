package com.arjunshaji.awt.demo.repository;

import com.arjunshaji.awt.demo.entity.Admin;
import com.arjunshaji.awt.demo.model.JWTRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<Admin,Long> {
    Admin findByUsername(String username);
}
