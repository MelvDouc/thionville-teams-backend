package com.chess.thionvilleteams.repository;

import com.chess.thionvilleteams.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MatchRepository extends JpaRepository<Match, Long> {
    /* @Query(nativeQuery = true, value = "SELECT" +
            "  tchMatch.id AS id," +
            "  tchMatch.round," +
            "  wTeam.name AS whiteTeam," +
            "  bTeam.name AS blackTeam," +
            "FROM tchMatch" +
            "  JOIN team wTeam ON wTeam.id = whiteTeamId" +
            "  JOIN team bTeam ON bTeam.id = blackTeamId " +
            "WHERE season = :season" +
            "  AND (whiteTeamId = :teamId OR blackTeamId = :teamId) " +
            "ORDER BY date") */
    @Query(value = "SELECT m FROM Match m WHERE m.season = :season AND (m.whiteTeam.id = :teamId OR m.blackTeam.id = :teamId)")
    List<Match> findBySeasonAndTeamId(int season, long teamId);

     /* @Query(nativeQuery = true, value = "SELECT" +
            "  ffeId," +
            "  firstName," +
            "  lastName," +
            "  bf.board," +
            "  IF((board % 2 = 1) = (whiteTeamId = player.teamId), 'B', 'N') AS color," +
            "  player.rating," +
            "  IF(bf.result IS NULL, -3.14, bf.result) AS result " +
            "FROM boardInfo bf" +
            "  JOIN player ON bf.playerId = player.id" +
            "  JOIN tchMatch ON bf.matchId = tchMatch.id " +
            "WHERE tchMatch.id = :matchId" +
            "  ORDER BY player.rating DESC")
    List<BoardInfo> findBoardInfoListByMatchId(long matchId); */

    interface BoardInfo extends IBoardInfo {
    }
}
