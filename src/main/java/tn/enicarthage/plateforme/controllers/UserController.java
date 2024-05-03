package tn.enicarthage.plateforme.controllers;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import tn.enicarthage.plateforme.entities.AuthRequest;
import tn.enicarthage.plateforme.entities.UserInfo;
import tn.enicarthage.plateforme.services.JwtService;
import tn.enicarthage.plateforme.services.UserInfoService;
import tn.enicarthage.plateforme.entities.Token;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserInfoService service;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping("/addNewUser")
    public String addNewUser(@RequestBody UserInfo userInfo) {
        return service.addUser(userInfo);
    }

    @PostMapping(path="/generateToken", produces = "application/json")
    public Token authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
        	Token tk = new Token();
        	tk.value = jwtService.generateToken(authRequest.getUsername());
            return tk;
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
    }

}
