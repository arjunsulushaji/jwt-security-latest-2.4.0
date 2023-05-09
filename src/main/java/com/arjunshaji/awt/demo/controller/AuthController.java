package com.arjunshaji.awt.demo.controller;

import com.arjunshaji.awt.demo.model.JWTRequest;
import com.arjunshaji.awt.demo.model.JWTResponse;
import com.arjunshaji.awt.demo.service.UserService;
import com.arjunshaji.awt.demo.utility.JWTUtility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthController {

    @Autowired
    private JWTUtility jwtUtility;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @PostMapping("/authenticate")
    public JWTResponse authenticate(@RequestBody JWTRequest jwtRequest) throws Exception {
        log.info("INSIDE AUTHENTICATE METHOD OF AUTH CONTROLLER");
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    jwtRequest.getUsername(),jwtRequest.getPassword()
            ));
        } catch (BadCredentialsException e){
            throw new Exception("INVALID CREDENTIALS.........",e);
        }
        final UserDetails userDetails =
                userService.loadUserByUsername(jwtRequest.getUsername());
        final String token =
                jwtUtility.generateToken(userDetails);
        return new JWTResponse(token);
    }
}
