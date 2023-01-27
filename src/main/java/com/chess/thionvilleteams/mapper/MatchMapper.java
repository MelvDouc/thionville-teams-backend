package com.chess.thionvilleteams.mapper;

import com.chess.thionvilleteams.dto.MatchDTO;
import com.chess.thionvilleteams.model.Match;
import org.springframework.stereotype.Component;

@Component
public class MatchMapper {
    public MatchDTO convert(Match match) {
        var matchDTO = new MatchDTO();
        matchDTO.setId(match.getId());
        matchDTO.setRound(match.getRound());
        matchDTO.setWhiteTeamName(match.getWhiteTeam().getName());
        matchDTO.setBlackTeamName(match.getBlackTeam().getName());
        matchDTO.setAddress(match.getHomeTeam().getAddress());
        matchDTO.setCity(match.getHomeTeam().getCity());
        matchDTO.setZip(match.getHomeTeam().getZip());
        matchDTO.setDate(match.getDate());
        
        return matchDTO;
    }
}
