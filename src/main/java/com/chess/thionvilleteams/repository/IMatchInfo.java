package com.chess.thionvilleteams.repository;

public interface IMatchInfo {
    long getId();

    int getRound();

    String getWhiteTeam();

    String getBlackTeam();

    String getAddress();

    String getCity();

    String getZip();

    String getDate();
}
