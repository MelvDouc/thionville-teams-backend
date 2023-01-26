package com.chess.thionvilleteams.repository;

import com.chess.thionvilleteams.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MatchRepository extends JpaRepository<Match, Long> {
    @Query(nativeQuery = true, value = "SELECT" +
            "  tchMatch.id AS id," +
            "  tchMatch.round," +
            "  wTeam.name AS whiteTeam," +
            "  bTeam.name AS blackTeam," +
            "  IF(whiteTeamId = homeTeamId, wTeam.address, bTeam.address) AS address," +
            "  IF(whiteTeamId = homeTeamId, wTeam.city, bTeam.city) AS city," +
            "  IF(whiteTeamId = homeTeamId, wTeam.zip, bTeam.zip) AS zip," +
            "  tchMatch.date " +
            "FROM tchMatch" +
            "  JOIN team wTeam ON wTeam.id = whiteTeamId" +
            "  JOIN team bTeam ON bTeam.id = blackTeamId " +
            "WHERE season = :season" +
            "  AND (whiteTeamId = :teamId OR blackTeamId = :teamId) " +
            "ORDER BY date")
    List<IMatchInfo> findBySeasonAndTeamId(int season, long teamId);

    @SuppressWarnings("unused")
    interface IMatchInfo {
        long getId();

        int getRound();

        String getWhiteTeam();

        String getBlackTeam();

        String getAddress();

        String getCity();

        String getZip();

        String getDate();
    }
}
