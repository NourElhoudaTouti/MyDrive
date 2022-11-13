package com.example.projectmiltone.Data.Repositories;

import com.example.projectmiltone.Data.Entities.User;

public interface UserRepository extends BaseRepository<User>{
    User findByUsername(String username);
}
