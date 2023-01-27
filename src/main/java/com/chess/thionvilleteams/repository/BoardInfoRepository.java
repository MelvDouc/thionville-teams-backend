package com.chess.thionvilleteams.repository;

import com.chess.thionvilleteams.model.BoardInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardInfoRepository extends JpaRepository<BoardInfo, Long> {
    @Query(value = "SELECT bi FROM BoardInfo bi WHERE bi.match.id = :matchId")
    List<BoardInfo> findByMatchId(long matchId);
}
