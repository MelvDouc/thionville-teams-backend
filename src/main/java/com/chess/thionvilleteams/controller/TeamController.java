package com.chess.thionvilleteams.controller;

import com.chess.thionvilleteams.model.Team;
import com.chess.thionvilleteams.service.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teams")
@SuppressWarnings("unused")
public class TeamController {
    private final TeamService service;

    public TeamController(TeamService teamService) {
        this.service = teamService;
    }

    @GetMapping
    public ResponseEntity<Team> getOne(@RequestParam("id") long id) {
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Team>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Team> createOne(@RequestBody Team team) {
        return new ResponseEntity<>(service.create(team), HttpStatus.OK);
    }
}
