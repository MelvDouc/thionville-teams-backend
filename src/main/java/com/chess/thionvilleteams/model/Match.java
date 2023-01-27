package com.chess.thionvilleteams.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tchMatch")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "round", nullable = false)
    private int round;
    @ManyToOne
    @JoinColumn(name = "whiteTeamId", nullable = false)
    private Team whiteTeam;
    @ManyToOne
    @JoinColumn(name = "blackTeamId", nullable = false)
    private Team blackTeam;
    @Column(name = "isWhiteHome", nullable = false)
    private boolean isWhiteHome;
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

    public Team getWhiteTeam() {
        return whiteTeam;
    }

    public void setWhiteTeam(Team whiteTeam) {
        this.whiteTeam = whiteTeam;
    }

    public Team getBlackTeam() {
        return blackTeam;
    }

    public void setBlackTeam(Team blackTeam) {
        this.blackTeam = blackTeam;
    }

    public Team getHomeTeam() {
        return (isWhiteHome)
            ? this.getWhiteTeam()
            : this.getBlackTeam();
    }

    public boolean isWhiteHome() {
        return isWhiteHome;
    }

    public void setWhiteHome(boolean whiteHome) {
        isWhiteHome = whiteHome;
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
