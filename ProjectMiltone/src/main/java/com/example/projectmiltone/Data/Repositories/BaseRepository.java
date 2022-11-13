package com.example.projectmiltone.Data.Repositories;

import com.example.projectmiltone.Data.Entities.BaseEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@NoRepositoryBean
public interface BaseRepository<E extends BaseEntity> extends CrudRepository<E, Long> {

}
