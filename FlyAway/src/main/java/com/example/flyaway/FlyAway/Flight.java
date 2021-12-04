package com.example.flyaway.FlyAway;

import javax.persistence.*;

@Entity
@Table(name = "Flight")
public class Flight {
    @Id
    @GeneratedValue
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column
    private String date;

    @Column
    private String source;

    @Column
    private String destination;

    @Column
    private String person;

    @Column
    private String flightprice;

    @Column
    private String airline;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getFlightprice() {
        return flightprice;
    }

    public void setFlightprice(String flightprice) {
        this.flightprice = flightprice;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }
}
