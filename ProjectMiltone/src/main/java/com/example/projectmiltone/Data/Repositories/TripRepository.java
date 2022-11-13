package com.example.projectmiltone.Data.Repositories;

import com.example.projectmiltone.Data.Entities.Trip;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

//BaseRepository<Trip>
@RepositoryRestResource
public interface TripRepository extends BaseRepository<Trip> {
   @Query("select t from Trip t where t.destination like %?1%")
   List<Trip> findByDestination(String destination);

    @Query("select t from Trip t where t.price between ?2 and ?3")
    List<Trip> findByPrice(float price);

    @Query("select t from Trip t where t.price between ?2 and ?3 and t.destination like %?1%")
    List<Trip> findByDestinationByPrice(float price,String destination);

    @Query("select t from Trip t where t.driverGender like %?1%  and t.destination like %?1% ")
    List<Trip> findByDestinationByDAndDriverGender(String driverGender ,String destination);

    @Query("select t from Trip t where t.driverGender like %?1%  and t.destination like %?1% and t.price between ?2 and ?3 ")
    List<Trip> findByDestinationByDAndDriverGenderAndByPrice(float price,String destination, String driverGender);

}
