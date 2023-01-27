package com.chess.thionvilleteams.controller;

import com.chess.thionvilleteams.model.Player;
import com.chess.thionvilleteams.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/players")
@SuppressWarnings("unused")
public class PlayerController extends ApiController<Player> {
    protected PlayerService service;

    public PlayerController(PlayerService service) {
        super(service);
    }

    public ResponseEntity<List<Player>> getAll(@RequestParam("team_id") Long teamId) {
        if (teamId != 0L)
            return getAllByTeamId(teamId);
        return super.getAll();
    }

    private ResponseEntity<List<Player>> getAllByTeamId(long teamId) {
        return new ResponseEntity<>(service.getAllByTeamId(teamId), HttpStatus.OK);
    }
}
