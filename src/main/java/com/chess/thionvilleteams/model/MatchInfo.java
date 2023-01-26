package com.chess.thionvilleteams.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class MatchInfo {
    @Id
    private long id;
    private int round;
    private String whiteTeam;
    private String blackTeam;
    private String address;
    private String city;
    private String zip;
    private String date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public String getWhiteTeam() {
        return whiteTeam;
    }

    public void setWhiteTeam(String whiteTeam) {
        this.whiteTeam = whiteTeam;
    }

    public String getBlackTeam() {
        return blackTeam;
    }

    public void setBlackTeam(String blackTeam) {
        this.blackTeam = blackTeam;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
