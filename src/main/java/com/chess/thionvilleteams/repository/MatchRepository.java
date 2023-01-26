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
    List<MatchInfo> findBySeasonAndTeamId(int season, long teamId);

    @Query(nativeQuery = true, value = "SELECT" +
            "  ffeId," +
            "  firstName," +
            "  lastName," +
            "  bf.board," +
            "  IF((board % 2 = 1) = (whiteTeamId = player.teamId), 'B', 'N') AS color," +
            "  bf.result " +
            "FROM boardInfo bf" +
            "  JOIN player ON bf.playerId = player.id" +
            "  JOIN tchMatch ON bf.matchId = tchMatch.id " +
            "WHERE tchMatch.id = :matchId" +
            "  ORDER BY player.rating DESC")
    List<BoardInfo> getBoardInfoList(long matchId);

    interface MatchInfo extends IMatchInfo {
    }

    interface BoardInfo extends IBoardInfo {
    }
}
