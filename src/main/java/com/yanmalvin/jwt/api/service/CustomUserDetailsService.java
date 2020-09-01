/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yanmalvin.jwt.api.service;

import com.yanmalvin.jwt.api.entity.User;
import com.yanmalvin.jwt.api.repository.UserRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author Malvin Pahlevi
 */
public class CustomUserDetailsService implements UserDetailsService{
    
    @Autowired
    private UserRepository repository;

    @Override
    // username as request header
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        // get user from db
        User user = repository.findByUsername(username);
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), new ArrayList<>());
    }
    
    
    
}
