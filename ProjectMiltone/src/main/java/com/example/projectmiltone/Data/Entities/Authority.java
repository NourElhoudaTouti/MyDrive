package com.example.projectmiltone.Data.Entities;



import org.springframework.lang.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;


@Entity
public class Authority  extends BaseEntity{
    @Column(name = "username")
    @NonNull
    private String username;

    @Column(name = "authority")
    @NotNull
    private String authority;

    public Authority() {
    }

    public Authority(@NonNull String username, String authority) {
        this.username = username;
        this.authority = authority;
    }


    @NonNull
    public String getUsername() {
        return username;
    }

    public void setUsername(@NonNull String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
