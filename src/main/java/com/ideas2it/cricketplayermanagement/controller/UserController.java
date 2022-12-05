package com.ideas2it.cricketplayermanagement.controller;

import com.ideas2it.cricketplayermanagement.model.JwtRequest;
import com.ideas2it.cricketplayermanagement.model.JwtResponse;
import com.ideas2it.cricketplayermanagement.model.User;
import com.ideas2it.cricketplayermanagement.service.UserService;
import com.ideas2it.cricketplayermanagement.util.exception.PlayerManagementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import com.ideas2it.cricketplayermanagement.util.config.JwtUtil;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;
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

    /**
     *
     * @param jwtRequest
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest jwtRequest) throws PlayerManagementException {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
       } catch (Exception playerManagementException) {
            throw new PlayerManagementException(HttpStatus.BAD_REQUEST,"Incorrect credentials");
        }
        final UserDetails userDetails = userService.loadUserByUsername(
                jwtRequest.getUsername()
        );
        final String jwt = jwtUtil.generateToken(userDetails);
        System.out.println(jwt);
        return ResponseEntity.ok(new JwtResponse(jwt));
    }
}
