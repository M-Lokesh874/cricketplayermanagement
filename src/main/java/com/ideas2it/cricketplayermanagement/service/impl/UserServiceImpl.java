package com.ideas2it.cricketplayermanagement.service.impl;

import com.ideas2it.cricketplayermanagement.model.User;
import com.ideas2it.cricketplayermanagement.repository.UserRepository;
import com.ideas2it.cricketplayermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return userRepository.findByUsername(userName);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
