package com.ideas2it.cricketplayermanagement.controller;

import com.ideas2it.cricketplayermanagement.model.CricketPlayer;
import com.ideas2it.cricketplayermanagement.model.JwtRequest;
import com.ideas2it.cricketplayermanagement.model.User;
import com.ideas2it.cricketplayermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping(value = "/saveUser")
    public ResponseEntity<?> createUser(@RequestBody User user)  {
        try {
            System.out.println(user);
            user = userService.saveUser(user);
            return ResponseEntity.of(Optional.of(user));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("User table does not exit");
        }
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
        } catch (BadCredentialsException badCredentialsException) {
            throw new Exception("Incorrect credentials", badCredentialsException);
        }
/*        final UserDetails userDetails = myUserDetailsService.loadUserByUsername(
                jwtRequest.getUsername()
        );*/
        /*  final String jwt = jwtUtil.generateToken(userDetails);*/
        return null; /*ResponseEntity.ok(new JwtResponse(jwt));*/
    }
}
