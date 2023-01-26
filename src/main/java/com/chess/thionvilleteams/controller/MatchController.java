package com.chess.thionvilleteams.controller;

import com.chess.thionvilleteams.model.Match;
import com.chess.thionvilleteams.model.MatchInfo;
import com.chess.thionvilleteams.service.ApiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/matches")
@SuppressWarnings("unused")
public class MatchController {
    private final ApiService apiService;
    public MatchController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping
    public ResponseEntity<Match> getOne(@RequestParam("id") long id) {
        return new ResponseEntity<>(
            apiService.getEntityById(apiService.MATCH_REPO, id),
            HttpStatus.OK
        );
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Match>> getAll() {
        return new ResponseEntity<>(
                apiService.getAllEntities(apiService.MATCH_REPO),
                HttpStatus.OK
        );
    }

    @RequestMapping(path = "/full-info", method = RequestMethod.GET)
    public ResponseEntity<List<MatchInfo>> getMatchesInfo(@RequestParam("season") int season, @RequestParam("team_id") long teamId) {
        return new ResponseEntity<>(apiService.getMatchesInfoBySeasonAndTeamId(season, teamId), HttpStatus.OK);
    }
}
