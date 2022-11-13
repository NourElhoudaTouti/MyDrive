package com.example.projectmiltone.Data.dtos;

public class Trip  {
    private long id;
    private int savailableseats;

    public Trip() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getSavailableseats() {
        return savailableseats;
    }

    public void setSavailableseats(int savailableseats) {
        this.savailableseats = savailableseats;
    }
}
