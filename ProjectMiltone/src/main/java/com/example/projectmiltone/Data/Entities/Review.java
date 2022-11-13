package com.example.projectmiltone.Data.Entities;

import com.example.projectmiltone.Data.Entities.BaseEntity;
import com.example.projectmiltone.Data.Entities.Trip;
import javax.validation.constraints.NotNull;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
//@Table(name = "Review")
public class Review extends BaseEntity {

    @ManyToOne
    @NotNull
    private Trip trip;

   // @Column(name = "eval")
    @NotNull
    private String eval;

    //@Column(name = "grade")
    private float grade;

    public Review() {
    }

    public Review(Trip trip, String eval, float grade) {
        this.trip = trip;
        this.eval = eval;
        this.grade = grade;
    }

    public Trip getTrip() {
        return trip;
    }


    public String getEval() {
        return eval;
    }

    public void setEval(String eval) {
        this.eval = eval;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }
}
