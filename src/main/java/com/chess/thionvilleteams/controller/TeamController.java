package com.chess.thionvilleteams.controller;

import com.chess.thionvilleteams.model.Team;
import com.chess.thionvilleteams.service.TeamService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/teams")
@SuppressWarnings("unused")
public class TeamController extends ApiController<Team> {
    protected TeamService service;

    public TeamController(TeamService service) {
        super(service);
    }
}
