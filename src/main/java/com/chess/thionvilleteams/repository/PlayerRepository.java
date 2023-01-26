package com.chess.thionvilleteams.repository;

import com.chess.thionvilleteams.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findAllByTeamIdOrderByRatingDesc(long teamId);
}
