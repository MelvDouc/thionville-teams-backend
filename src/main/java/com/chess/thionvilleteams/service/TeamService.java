package com.chess.thionvilleteams.service;

import com.chess.thionvilleteams.exception.ResourceNotFoundException;
import com.chess.thionvilleteams.model.Team;
import com.chess.thionvilleteams.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService implements IService<Team> {
    private final TeamRepository repository;

    public TeamService(TeamRepository repository) {
        this.repository = repository;
    }

    @Override
    public Team getById(long id) throws ResourceNotFoundException {
        Optional<Team> team = repository.findById(id);

        if (team.isPresent())
            return team.get();

        throw new ResourceNotFoundException("Team", "id", id);
    }

    @Override
    public List<Team> getAll() {
        return repository.findAll();
    }

    @Override
    public Team create(Team team) {
        return repository.save(team);
    }

    @Override
    public Team update(Team team, long id) {
        Team teamInDb = getById(id);

        if (!team.getName().equals(teamInDb.getName()))
            teamInDb.setName(team.getName());
        if (!team.getAddress().equals(teamInDb.getAddress()))
            teamInDb.setAddress(team.getAddress());
        if (!team.getAddress().equals(teamInDb.getAddress()))
            teamInDb.setAddress(team.getAddress());
        if (!team.getCity().equals(teamInDb.getCity()))
            teamInDb.setCity(team.getCity());
        if (!team.getZip().equals(teamInDb.getZip()))
            teamInDb.setZip(team.getZip());
        if (!team.getTel().equals(teamInDb.getTel()))
            teamInDb.setTel(team.getTel());
        if (!team.getWebsite().equals(teamInDb.getWebsite()))
            teamInDb.setWebsite(team.getWebsite());

        return repository.save(teamInDb);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
}
