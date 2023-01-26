package com.chess.thionvilleteams.controller;

import com.chess.thionvilleteams.model.Player;
import com.chess.thionvilleteams.service.ApiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/players")
@SuppressWarnings("unused")
public class PlayerController {
    private final ApiService apiService;

    public PlayerController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping
    public ResponseEntity<Player> getOne(@RequestParam("id") long id) {
        return new ResponseEntity<>(
            apiService.getEntityById(apiService.PLAYER_REPO, id),
            HttpStatus.OK
        );
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Player>> getAll(@RequestParam("team_id") Optional<Long> teamId) {
        final long id = teamId.orElse(0L);
        if (id != 0L) return getAllByTeamId(id);
        return new ResponseEntity<>(
            apiService.getAllEntities(apiService.PLAYER_REPO),
            HttpStatus.OK
        );
    }

    private ResponseEntity<List<Player>> getAllByTeamId(long teamId) {
        return new ResponseEntity<>(
            apiService.getPlayersByTeamId(teamId),
            HttpStatus.OK
        );
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Player> createOne(@RequestBody Player player) {
        return new ResponseEntity<>(
            apiService.createEntity(apiService.PLAYER_REPO, player),
            HttpStatus.OK
        );
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Player> updateOne(@RequestBody Player player, @RequestParam long id) {
        return new ResponseEntity<>(
            apiService.updatePlayer(player, id), HttpStatus.OK
        );
    }
}
