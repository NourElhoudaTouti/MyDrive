package com.example.projectmiltone.Data.Repositories;

import com.example.projectmiltone.Data.Entities.Authority;

import java.util.List;

public interface AuthorityRepository extends BaseRepository<Authority> {
    List<Authority> findByAuthority(String authority);
}
