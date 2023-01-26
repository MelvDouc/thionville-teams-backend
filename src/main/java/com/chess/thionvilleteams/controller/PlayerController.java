package com.chess.thionvilleteams.controller;

import com.chess.thionvilleteams.model.Player;
import com.chess.thionvilleteams.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/players")
@SuppressWarnings("unused")
public class PlayerController {
    private final PlayerService service;

    public PlayerController(PlayerService playerService) {
        this.service = playerService;
    }

    @GetMapping
    public ResponseEntity<Player> getOne(@RequestParam("id") long id) {
        return new ResponseEntity<>(
                service.getById(id),
                HttpStatus.OK
        );
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Player>> getAll(@RequestParam("team_id") Optional<Long> teamId) {
        final long id = teamId.orElse(0L);
        if (id != 0L) return getAllByTeamId(id);
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    private ResponseEntity<List<Player>> getAllByTeamId(long teamId) {
        return new ResponseEntity<>(service.getAllByTeamId(teamId), HttpStatus.OK);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Player> createOne(@RequestBody Player player) {
        return new ResponseEntity<>(service.create(player), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Player> updateOne(@RequestBody Player player, @RequestParam("id") long id) {
        return new ResponseEntity<>(service.update(player, id), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<Long> deleteOne(@RequestParam("id") long id) {
        service.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
