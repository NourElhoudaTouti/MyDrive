package com.example.projectmiltone.Data.Repositories;

import com.example.projectmiltone.Data.Entities.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
@RepositoryRestResource
public interface ReviewRepository extends BaseRepository<Review>{
    @Query("select r from Review r where r.trip.id = ?1")
    List<Review> findByTrip(long tripId);
}
