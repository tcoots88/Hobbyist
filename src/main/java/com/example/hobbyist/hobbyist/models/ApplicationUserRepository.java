package com.example.hobbyist.hobbyist.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
    public UserDetails findByUsername(String username);
}
