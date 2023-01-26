package com.chess.thionvilleteams.repository;

import com.chess.thionvilleteams.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> { }
