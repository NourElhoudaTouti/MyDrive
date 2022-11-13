package com.example.projectmiltone.Data.Entities;

import javax.validation.constraints.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Trips")
public class Trip extends BaseEntity {

   // @Column(name = "destination")
    @NotNull
    private String destination;

   // @Column(name = "price")
    @NotNull
    private float price;
    //@Column(name = "drivergender")
    @NotNull
    private String driverGender;
    //@Column(name = "availableseats")
    @NotNull
    private int availableseats;

    //@Column(name = "reviews")
    @OneToMany
            //(mappedBy = "Review", fetch = FetchType.LAZY)
    private List<Review> reviews;


    public Trip( String destination, float price, String driverGender,int availableseats) {
        this.destination = destination;
        this.price = price;
        this.driverGender = driverGender;
        this.availableseats=availableseats;
        active=false;
    }

    public Trip() {

    }


    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDriverGender() {
        return driverGender;
    }

    public void setDriverGender(String driverGender) {
        this.driverGender = driverGender;
    }

    public int getAvailableseats() {
        return availableseats;
    }

    public void setAvailableseats(int availableseats) {
        this.availableseats = availableseats;
    }
    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
