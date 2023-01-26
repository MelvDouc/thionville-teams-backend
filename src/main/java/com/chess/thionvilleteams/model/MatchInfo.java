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
}
