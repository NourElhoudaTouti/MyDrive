package com.example.projectmiltone.Data.dtos;

import com.example.projectmiltone.Data.Entities.Trip;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public class Cart {
    private Hashtable<Trip, Integer> selectedTrips;
    private float TripsTotalPrice;

    public Cart() {
        selectedTrips = new Hashtable<Trip, Integer>();
        TripsTotalPrice = 0;
    }

    public void addTrip(Trip trip, int seatavailable){
        if(seatavailable <= 0)
            return;
        updateTripAvailableSeats(trip, seatavailable);
    }

    public void removeTrip(Trip trip, int seatavailable){
        if(seatavailable <= 0)
            return;
        updateTripAvailableSeats(trip, -1 * seatavailable);
    }

    public void removeTrip(Trip trip){
        if(selectedTrips.get(trip) != null)
            removeTrip(trip, selectedTrips.get(trip));
    }

    private void updateTripAvailableSeats(Trip trip, int quantity) {
        int currentQuantity = 0;
        if(selectedTrips.get(trip) != null)
            currentQuantity = selectedTrips.get(trip);


        if(quantity + currentQuantity < 0)
            quantity = -1 * currentQuantity;
        if(quantity + currentQuantity == 0)
            selectedTrips.remove(trip);
        else
            selectedTrips.put(trip, quantity + currentQuantity);

        //Recompute productsTotalPrice and shippingCost
        //We could just update them, but a discount may be applied by back office meanwhile
        Iterator<Map.Entry<Trip, Integer>> it = selectedTrips.entrySet().iterator();
        TripsTotalPrice = 0;

        while(it.hasNext()){
            Map.Entry<Trip, Integer> e = it.next();
            TripsTotalPrice += e.getKey().getPrice()  * e.getValue();
        }
    }

    public boolean isEmpty(){
        return TripsTotalPrice == 0;
    }
    public void empty(){
        selectedTrips = new Hashtable<Trip, Integer>();
        TripsTotalPrice = 0;
    }

    public Hashtable<Trip, Integer> getSelectedTrips() {
        return selectedTrips;
    }

    public void setSelectedTrips(Hashtable<Trip, Integer> selectedTrips) {
        this.selectedTrips = selectedTrips;
    }

    public float getTripsTotalPrice() {
        return TripsTotalPrice;
    }

    public void setTripsTotalPrice(float tripsTotalPrice) {
        TripsTotalPrice = tripsTotalPrice;
    }
}
