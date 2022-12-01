package com.ideas2it.cricketplayermanagement.service;

import com.ideas2it.cricketplayermanagement.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    public User saveUser(User user);
}
