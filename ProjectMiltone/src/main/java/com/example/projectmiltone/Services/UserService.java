package com.example.projectmiltone.Services;

import com.example.projectmiltone.Data.Entities.Authority;
import com.example.projectmiltone.Data.Entities.User;
import com.example.projectmiltone.Data.Repositories.AuthorityRepository;
import com.example.projectmiltone.Data.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthorityRepository authorityRepository;

    //create admin account
    public boolean createSuperAdmin(String username, String password, String firstName, String lastName, String emailAddress) {

        if (!authorityRepository.findByAuthority("ROLE_SUPERADMIN").isEmpty())
            return false;

        String[] authorities = { "ROLE_SUPERADMIN" };
        create(username, password, firstName, lastName, emailAddress, authorities);
        return true;
    }
    // Create back staff office account
    public void createAdmin(String username, String password, String firstName, String lastName, String emailAddress) {

        String[] authorities = { "ROLE_ADMIN", "ROLE_USER" };
        create(username, password, firstName, lastName, emailAddress, authorities);
    }

    // Create regular user account
    public void createUser(String username, String password, String firstName, String lastName, String emailAddress) {

        String[] authorities = { "ROLE_USER" };
        create(username, password, firstName, lastName, emailAddress, authorities);
    }
    // Generic create method
    private void create(String username, String password, String firstName, String lastName, String emailAddress, String[] authorities) {

        User user = new User(username, password, firstName, lastName, emailAddress);
        userRepository.save(user);
        for (String auth : authorities) {
            Authority authority = new Authority(username, auth);
            authorityRepository.save(authority);
        }
    }

        // Generic update method
        public void update(long userId, String password, String newPassword, String firstName, String lastName, String emailAddress) {
            User user = userRepository.findById(userId).get();
            if (password != null && (newPassword == null
                    || !(new BCryptPasswordEncoder().encode(password).equals(user.getPassword())))) {
                return;
            }

            if (newPassword != null)
                user.setPassword(new BCryptPasswordEncoder().encode(newPassword));
            if (firstName != null)
                user.setFirstName(firstName);
            if (lastName != null)
                user.setLastName(lastName);
            if (emailAddress != null)
                user.setEmailAddress(emailAddress);


            userRepository.save(user);
        }

    }

