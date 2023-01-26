package com.chess.thionvilleteams.repository;

import com.chess.thionvilleteams.model.MatchInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchInfoRepository extends JpaRepository<MatchInfo, Long> {
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
            "WHERE season = ?1" +
            "  AND (whiteTeamId = ?2 OR blackTeamId = ?2) " +
            "ORDER BY date")
    List<MatchInfo> findBySeasonAndTeamId(int season, long teamId);
}
