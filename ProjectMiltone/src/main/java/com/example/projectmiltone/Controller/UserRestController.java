package com.example.projectmiltone.Controller;


import com.example.projectmiltone.Data.dtos.User;
import com.example.projectmiltone.Security.JwtHelper;
import com.example.projectmiltone.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/user")
public class UserRestController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @PostMapping("/authenticate")
    public String authenticate(@RequestBody User dto) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));
        return JwtHelper.generateToken(authentication);
    }

    @PostMapping("/admin")
    public boolean createAdmin(@RequestBody User dto) {
        if (!check(dto))
            return false;

        userService.createAdmin(dto.getUsername(), dto.getPassword(), dto.getFirstName(), dto.getLastName(),
                dto.getEmailAddress());
        return true;
    }

    @PostMapping
    public boolean createUser(@RequestBody User dto) {
        if (!check(dto))
            return false;

        userService.createUser(dto.getUsername(), dto.getPassword(), dto.getFirstName(), dto.getLastName(),
                dto.getEmailAddress());
        return true;
    }

    @PatchMapping("/{userId}")
    public User update(@PathVariable("userId") long userId, @RequestBody User dto) {
        if (userId < 1)
            throw new RuntimeException();

        userService.update(userId, dto.getPassword(), dto.getNewPassword(), dto.getFirstName(), dto.getLastName(),
                dto.getEmailAddress());

        return new User(dto.getUsername(), dto.getPassword(), dto.getFirstName(),dto.getLastName(), dto.getEmailAddress());

    }

    private boolean check(User dto) {
        return (dto.getUsername() != null && dto.getPassword() != null && dto.getFirstName() != null
                && dto.getLastName() != null && dto.getEmailAddress() != null );
    }

}
