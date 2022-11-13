package com.example.projectmiltone.Data.Entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ReservationLine")
public class ReservationLine extends BaseEntity{
    @ManyToOne
    @NotNull
    private Reservation reservation;

    @ManyToOne
    @NotNull
    private Trip trip;

    private float unitPrice;
    private transient float price;
    private int seatavailable;

    public ReservationLine() {
    }


    public ReservationLine(Reservation reservation, Trip trip, int seatavailable) {
        this.reservation = reservation;
        this.trip = trip;
        this.seatavailable=seatavailable;
        this.unitPrice = trip.getPrice();
        price= unitPrice * seatavailable;
    }

    //public Reservation getReservation() {
     //   return reservation;
    //}

    public Trip getTrip() {
        return trip;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public float getPrice() {
        return price;
    }

    public int getSeatavailable() {
        return seatavailable;
    }
}
