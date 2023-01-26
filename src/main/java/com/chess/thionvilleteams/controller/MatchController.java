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

    public MatchController(MatchService matchService) {
        this.service = matchService;
    }

    @GetMapping
    public ResponseEntity<Match> getOne(@RequestParam("id") long id) {
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Match>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @RequestMapping(path = "/full-info", method = RequestMethod.GET)
    public ResponseEntity<List<MatchRepository.IMatchInfo>> getMatchesInfo(@RequestParam("season") int season, @RequestParam("team_id") long teamId) {
        return new ResponseEntity<>(service.getMatchesInfoBySeasonAndTeamId(season, teamId), HttpStatus.OK);
    }
}
