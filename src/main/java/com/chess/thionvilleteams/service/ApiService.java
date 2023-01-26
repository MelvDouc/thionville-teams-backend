package com.chess.thionvilleteams.service;

import com.chess.thionvilleteams.exception.ResourceNotFoundException;
import com.chess.thionvilleteams.model.Player;
import com.chess.thionvilleteams.repository.PlayerRepository;
import com.chess.thionvilleteams.repository.TeamRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ApiService {
    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;

    public ApiService(PlayerRepository playerRepository, TeamRepository teamRepository) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
    }

    private String getUpdatedAt() {
        TimeZone timeZone = TimeZone.getTimeZone("UTC");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // Quoted "Z" to indicate UTC, no timezone offset
        dateFormat.setTimeZone(timeZone);
        return dateFormat.format(new Date());
    }

    public PlayerRepository getPlayerRepository() {
        return playerRepository;
    }

    public TeamRepository getTeamRepository() {
        return teamRepository;
    }

    public <T> T getEntityById(JpaRepository<T, Long> repository, long id) throws ResourceNotFoundException {
        Optional<T> entity = repository.findById(id);

        if (entity.isPresent())
            return entity.get();

        throw new ResourceNotFoundException(entity.getClass().getName(), "id", id);
    }

    public <T> List<T> getAllEntities(JpaRepository<T, Long> repository) {
        return repository.findAll();
    }

    public List<Player> getPlayersByTeamId(long teamId) {
        return playerRepository.findAllByTeamIdOrderByRatingDesc(teamId);
    }

    public <T> T createEntity(JpaRepository<T, Long> repository, T entity) {
        return repository.save(entity);
    }

    public Player updatePlayer(Player player, long id) {
        Player playerInDb = getEntityById(playerRepository, id);

        if (player.getFfeId() != null)
            playerInDb.setFfeId(player.getFfeId());
        if (player.getFirstName() != null)
            playerInDb.setFirstName(player.getFirstName());
        if (player.getLastName() != null)
            playerInDb.setLastName(player.getLastName());
        if (player.getEmail() != null)
            playerInDb.setEmail(player.getEmail());
        if (player.getTel() != null)
            playerInDb.setTel(player.getTel());
        if (player.getRating() != playerInDb.getRating())
            playerInDb.setRating(player.getRating());
        if (player.getTeamId() != playerInDb.getTeamId())
            playerInDb.setTeamId(player.getTeamId());
        playerInDb.setUpdatedAt(getUpdatedAt());

        return playerRepository.save(playerInDb);
    }
}
