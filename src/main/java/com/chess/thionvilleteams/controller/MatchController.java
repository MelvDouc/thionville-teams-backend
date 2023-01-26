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
    public ResponseEntity<Match> getMatchById(@RequestParam("id") long id) {
        return new ResponseEntity<>(
            apiService.getEntityById(apiService.getTchMatchRepository(), id),
            HttpStatus.OK
        );
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Match>> getMatches() {
        return new ResponseEntity<>(
                apiService.getAllEntities(apiService.getTchMatchRepository()),
                HttpStatus.OK
        );
    }

    @RequestMapping(path = "/full-info", method = RequestMethod.GET)
    public ResponseEntity<MatchInfo> getTchMatchFullInfo(@RequestParam("match_id") long matchId) {
        return new ResponseEntity<>(apiService.getTchMatchFullInfo(matchId), HttpStatus.OK);
    }
}
