package com.chess.thionvilleteams.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tchMatch")
public class TchMatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "round", nullable = false)
    private int round;
    @Column(name = "whiteTeamId", nullable = false)
    private long whiteTeamId;
    @Column(name = "blackTeamId", nullable = false)
    private long blackTeamId;
    @Column(name = "homeTeamId", nullable = false)
    private long homeTeamId;
    @Column(name = "season", nullable = false)
    private int season;
    @Column(name = "date", nullable = false)
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

    public long getWhiteTeamId() {
        return whiteTeamId;
    }

    public void setWhiteTeamId(long whiteTeamId) {
        this.whiteTeamId = whiteTeamId;
    }

    public long getBlackTeamId() {
        return blackTeamId;
    }

    public void setBlackTeamId(long blackTeamId) {
        this.blackTeamId = blackTeamId;
    }

    public long getHomeTeamId() {
        return homeTeamId;
    }

    public void setHomeTeamId(long homeTeamId) {
        this.homeTeamId = homeTeamId;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
