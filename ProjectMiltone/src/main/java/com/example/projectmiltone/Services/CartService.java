package com.example.projectmiltone.Services;

import com.example.projectmiltone.Data.Entities.Trip;
import com.example.projectmiltone.Data.Repositories.TripRepository;
import com.example.projectmiltone.Data.dtos.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    @Autowired
    private TripRepository tripRepository;

    @Cacheable(value = "Cart")
    public Cart getCart(long userId) {
        return new Cart();
    }

    @CachePut(value = "Cart", key = "#userId")
    public Cart addTrip(Cart cart, long userId, long tripId, int seatavailabel) {
        Trip trip = tripRepository.findById(tripId).get();
        cart.addTrip(trip,seatavailabel);
        return cart;
    }

    @CachePut(value = "Cart", key = "#userId")
    public Cart decreaseTripAvailableseats(Cart cart, long userId, long tripId, int seatavailable) {
        Trip trip = tripRepository.findById(tripId).get();
        cart.removeTrip(trip,seatavailable);
        return cart;
    }
    @CachePut(value = "Cart", key = "#userId")
    public Cart removeTrip(Cart cart, long userId, long tripId) {
        Trip trip = tripRepository.findById(tripId).get();
        cart.removeTrip(trip);
        return cart;
    }
    @CachePut(value = "Cart", key = "#userId")
    public Cart empty(Cart cart, long userId) {
        cart.empty();
        return cart;
    }



}
