package com.example.projectmiltone.Data.Entities;

import com.example.projectmiltone.Data.dtos.Cart;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Iterator;
import java.util.Map;

@Entity
@Table(name = "\"Reservation\"")
public class Reservation extends BaseEntity{
    @ManyToOne
    @NotNull
    protected User user;

    @OneToMany(mappedBy = "reservation", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    protected List<ReservationLine> reservationLines;

    protected ReservationStatus status;
    protected float tripsTotalPrice;

    public Reservation() {

    }

    public Reservation(Cart cart, User user) {
        this.user=user;
        if(cart.getSelectedTrips()!= null){
            Iterator<Map.Entry<Trip, Integer>> it = cart.getSelectedTrips().entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Trip, Integer> e = it.next();
                new ReservationLine(this, e.getKey(), e.getValue());
            }
        }
        tripsTotalPrice = cart.getTripsTotalPrice();
        status = ReservationStatus.HANDLING;
    }



    /*public void updateStatus(ReservationStatus newStatus) throws IllegalStatusChangeException {
        if (status == ReservationStatus.CANCELED || status == ReservationStatus.DONE)
            throw new IllegalStatusChangeException(newStatus);
        status = newStatus;

    }*/

    public User getUser() {
        return user;
    }

    public List<ReservationLine> getReservationLines() {
        return reservationLines;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public float getTripsTotalPrice() {
        return tripsTotalPrice;
    }

    public void setReservationLines(List<ReservationLine> reservationLines) {
        this.reservationLines = reservationLines;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    public void setTripsTotalPrice(float tripsTotalPrice) {
        this.tripsTotalPrice = tripsTotalPrice;
    }
}
