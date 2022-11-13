package com.example.projectmiltone.Data.Repositories;

import com.example.projectmiltone.Data.Entities.Reservation;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservationRepository extends BaseRepository<Reservation>{
    @Query("select o from Reservation o where o.user.id = ?1")
    List<Reservation> findByCustomer(long userId);
}

