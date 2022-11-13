package com.example.projectmiltone.Data.Entities;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "\"user\"")
public class User extends  BaseEntity{

    @NotNull
    protected String username;
    @NotNull
    protected String password;

    @NotNull
    protected String firstName;

    @NotNull
    protected String lastName;

    @NotNull
    protected String emailAddress;

    public User() {
    }

    public User(String username, String password, String firstName, String lastName, String emailAddress) {
        this.username = username;
        this.password = new BCryptPasswordEncoder().encode(password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
