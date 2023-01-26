package com.chess.thionvilleteams.controller;

import com.chess.thionvilleteams.model.Player;
import com.chess.thionvilleteams.repository.PlayerRepository;
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
    private final PlayerRepository playerRepository;

    public PlayerController(ApiService apiService) {
        this.apiService = apiService;
        this.playerRepository = apiService.getPlayerRepository();
    }

    @GetMapping
    public ResponseEntity<Player> getPlayerById(@RequestParam("id") long id) {
        return new ResponseEntity<>(
            apiService.getEntityById(playerRepository, id),
            HttpStatus.OK
        );
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Player>> getPlayers(@RequestParam("team_id") Optional<Long> teamId) {
        final long id = teamId.orElse(0L);
        if (id != 0L) return getPlayersByTeamId(id);
        return new ResponseEntity<>(
            apiService.getAllEntities(playerRepository),
            HttpStatus.OK
        );
    }

    private ResponseEntity<List<Player>> getPlayersByTeamId(long teamId) {
        return new ResponseEntity<>(
            apiService.getPlayersByTeamId(teamId),
            HttpStatus.OK
        );
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Player> createPlayer(@RequestBody Player player) {
        return new ResponseEntity<>(
            apiService.createEntity(playerRepository, player),
            HttpStatus.OK
        );
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Player> updatePlayer(@RequestBody Player player, @RequestParam long id) {
        return new ResponseEntity<>(
            apiService.updatePlayer(player, id), HttpStatus.OK
        );
    }
}
