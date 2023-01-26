package com.chess.thionvilleteams.controller;

import com.chess.thionvilleteams.model.Match;
import com.chess.thionvilleteams.repository.MatchRepository;
import com.chess.thionvilleteams.service.MatchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/matches")
@SuppressWarnings("unused")
public class MatchController {
    private final MatchService service;
    private final MatchRepository matchRepository;

    public MatchController(MatchService matchService,
                           MatchRepository matchRepository) {
        this.service = matchService;
        this.matchRepository = matchRepository;
    }

    @GetMapping
    public ResponseEntity<Match> getOne(@RequestParam("id") long id) {
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Match>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @RequestMapping(path = "/board-info", method = RequestMethod.GET)
    public ResponseEntity<List<MatchRepository.BoardInfo>> getBoardInfoList(@RequestParam("match_id") long matchId) {
        return new ResponseEntity<>(matchRepository.getBoardInfoList(matchId), HttpStatus.OK);
    }

    @RequestMapping(path = "/match-info", method = RequestMethod.GET)
    public ResponseEntity<List<MatchRepository.MatchInfo>> getMatchInfoList(@RequestParam("season") int season, @RequestParam("team_id") long teamId) {
        return new ResponseEntity<>(service.getMatchInfoListBySeasonAndTeamId(season, teamId), HttpStatus.OK);
    }
}
