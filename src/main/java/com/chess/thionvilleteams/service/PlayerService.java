package com.chess.thionvilleteams.service;

import com.chess.thionvilleteams.exception.ResourceNotFoundException;
import com.chess.thionvilleteams.model.Player;
import com.chess.thionvilleteams.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService implements IService<Player> {
    private final PlayerRepository repository;

    public PlayerService(PlayerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Player getById(long id) throws ResourceNotFoundException {
        Optional<Player> player = repository.findById(id);

        if (player.isPresent())
            return player.get();

        throw new ResourceNotFoundException("Player", "id", id);
    }

    @Override
    public List<Player> getAll() {
        return repository.findAll();
    }

    public List<Player> getAllByTeamId(long teamId) {
        return repository.findAllByTeamIdOrderByRatingDesc(teamId);
    }

    @Override
    public Player create(Player player) {
        return repository.save(player);
    }

    @Override
    public Player update(Player player, long id) {
        var playerInDb = getById(id);
        var ffeId = player.getFfeId();
        var firstName = player.getFirstName();
        var lastName = player.getLastName();
        var email = player.getEmail();
        var tel = player.getTel();
        var rating = player.getRating();
        var teamId = player.getTeamId();

        if (ffeId != null && !ffeId.equals(playerInDb.getFfeId()))
            playerInDb.setFfeId(ffeId);
        if (firstName != null && !firstName.equals(playerInDb.getFirstName()))
            playerInDb.setFirstName(firstName);
        if (lastName != null && !lastName.equals(playerInDb.getLastName()))
            playerInDb.setLastName(lastName);
        if (email != null && !email.equals(playerInDb.getEmail()))
            playerInDb.setEmail(email);
        if (tel != null && !tel.equals(playerInDb.getTel()))
            playerInDb.setTel(tel);
        if (rating != 0 && rating != playerInDb.getRating())
            playerInDb.setRating(rating);
        if (teamId != playerInDb.getTeamId())
            playerInDb.setTeamId(teamId);
        playerInDb.setUpdatedAt(ServiceUtils.getUpdateTime());

        return repository.save(playerInDb);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
}
