package com.example.projectmiltone.Services;

import com.example.projectmiltone.Data.Entities.Trip;
import com.example.projectmiltone.Data.Repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TripService {

    private final TripRepository tripRep;

    @Autowired
    public TripService(TripRepository tripRep) {
        this.tripRep = tripRep;
    }

    public List<Trip> getTips() {
        return (List<Trip>) tripRep.findAll();
    }
}
