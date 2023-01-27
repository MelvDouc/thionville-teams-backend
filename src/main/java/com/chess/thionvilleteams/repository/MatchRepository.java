package com.chess.thionvilleteams.repository;

import com.chess.thionvilleteams.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MatchRepository extends JpaRepository<Match, Long> {
    @Query(value = "SELECT m FROM Match m WHERE m.season = :season AND (m.whiteTeam.id = :teamId OR m.blackTeam.id = :teamId)")
    List<Match> findBySeasonAndTeamId(int season, long teamId);
}
