package com.example.projectmiltone.Security;

import com.example.projectmiltone.Data.Entities.User;
import com.example.projectmiltone.Data.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class UserAuditor implements AuditorAware<User> {
    @Autowired
    UserRepository userRepository;

    @Override
    public Optional<User> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            System.out.println("Null authentication");
            return null;
        }

        String username = (String)authentication.getPrincipal();
        System.out.println("username: " + username);
        return Optional.ofNullable(userRepository.findByUsername(username));
    }
}
