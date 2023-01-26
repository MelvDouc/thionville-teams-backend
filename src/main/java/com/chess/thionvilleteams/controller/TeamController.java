package com.chess.thionvilleteams.controller;

import com.chess.thionvilleteams.model.Team;
import com.chess.thionvilleteams.service.ApiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teams")
@SuppressWarnings("unused")
public class TeamController {
    private final ApiService apiService;

    public TeamController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping
    public ResponseEntity<Team> getOne(@RequestParam("id") long id) {
        return new ResponseEntity<>(
            apiService.getEntityById(apiService.TEAM_REPO, id),
            HttpStatus.OK
        );
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Team>> getAll() {
        return new ResponseEntity<>(
            apiService.getAllEntities(apiService.TEAM_REPO),
            HttpStatus.OK
        );
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Team> createOne(@RequestBody Team team) {
        return new ResponseEntity<>(
                apiService.createEntity(apiService.TEAM_REPO, team),
                HttpStatus.OK
        );
    }
}
