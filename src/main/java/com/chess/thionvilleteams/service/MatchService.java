package com.chess.thionvilleteams.service;

import com.chess.thionvilleteams.exception.ResourceNotFoundException;
import com.chess.thionvilleteams.model.Match;
import com.chess.thionvilleteams.repository.MatchRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatchService implements IService<Match> {
    private final MatchRepository matchRepository;

    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @Override
    public Match getById(long id) throws ResourceNotFoundException {
        Optional<Match> match = matchRepository.findById(id);

        if (match.isPresent())
            return match.get();

        throw new ResourceNotFoundException("Player", "id", id);
    }

    @Override
    public List<Match> getAll() {
        return matchRepository.findAll();
    }

    public List<MatchRepository.MatchInfo> getMatchInfoListBySeasonAndTeamId(int season, long teamId) {
        return matchRepository.findBySeasonAndTeamId(season, teamId);
    }

    public List<MatchRepository.BoardInfo> getBoardInfoList(long matchId) {
        return matchRepository.getBoardInfoList(matchId);
    }

    @Override
    public Match create(Match match) {
        return matchRepository.save(match);
    }

    @Override
    public Match update(Match match, long id) {
        Match matchInDb = getById(id);

        if (match.getRound() != matchInDb.getRound())
            matchInDb.setRound(match.getRound());
        if (match.getWhiteTeamId() != matchInDb.getWhiteTeamId())
            matchInDb.setWhiteTeamId(match.getWhiteTeamId());
        if (match.getBlackTeamId() != matchInDb.getBlackTeamId())
            matchInDb.setBlackTeamId(match.getBlackTeamId());
        if (match.getHomeTeamId() != matchInDb.getHomeTeamId())
            matchInDb.setHomeTeamId(match.getHomeTeamId());
        if (match.getSeason() != matchInDb.getSeason())
            matchInDb.setSeason(match.getSeason());
        if (!match.getDate().equals(matchInDb.getDate()))
            matchInDb.setDate(match.getDate());

        return matchRepository.save(matchInDb);
    }

    @Override
    public void delete(long id) {
        matchRepository.deleteById(id);
    }
}
