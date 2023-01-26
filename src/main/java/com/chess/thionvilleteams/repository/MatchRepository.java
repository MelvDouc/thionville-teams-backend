package com.chess.thionvilleteams.repository;

import com.chess.thionvilleteams.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Long> {}
