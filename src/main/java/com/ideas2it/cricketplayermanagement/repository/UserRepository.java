package com.ideas2it.cricketplayermanagement.repository;

import com.ideas2it.cricketplayermanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    public User findByUsername(String username);
}
