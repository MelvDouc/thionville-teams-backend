package com.chess.thionvilleteams.dto;

public class MatchDTO {
    private long id;
    private int round;
    private String whiteTeamName;
    private String blackTeamName;
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

    public String getWhiteTeamName() {
        return whiteTeamName;
    }

    public void setWhiteTeamName(String whiteTeamName) {
        this.whiteTeamName = whiteTeamName;
    }

    public String getBlackTeamName() {
        return blackTeamName;
    }

    public void setBlackTeamName(String blackTeamName) {
        this.blackTeamName = blackTeamName;
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
