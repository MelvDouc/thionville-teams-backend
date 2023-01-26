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
        Player playerInDb = getById(id);

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
        playerInDb.setUpdatedAt(ServiceUtils.getUpdateTime());

        return repository.save(playerInDb);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
}
