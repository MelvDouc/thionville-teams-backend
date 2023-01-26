package com.chess.thionvilleteams.controller;

import com.chess.thionvilleteams.model.Team;
import com.chess.thionvilleteams.repository.TeamRepository;
import com.chess.thionvilleteams.service.ApiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teams")
public class TeamController {
    private final ApiService apiService;
    private final TeamRepository teamRepository;

    public TeamController(ApiService apiService) {
        this.apiService = apiService;
        this.teamRepository = apiService.getTeamRepository();
    }

    @GetMapping
    public ResponseEntity<Team> getTeamById(@RequestParam("id") long id) {
        return new ResponseEntity<>(
            apiService.getEntityById(teamRepository, id),
            HttpStatus.OK
        );
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Team>> getTeams() {
        return new ResponseEntity<>(
            apiService.getAllEntities(teamRepository),
            HttpStatus.OK
        );
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Team> createTeam(@RequestBody Team team) {
        return new ResponseEntity<>(
                apiService.createEntity(teamRepository, team),
                HttpStatus.OK
        );
    }
}
