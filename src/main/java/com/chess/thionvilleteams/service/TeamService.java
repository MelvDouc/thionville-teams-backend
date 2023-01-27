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
        var teamInDb = getById(id);
        var name = team.getName();
        var address = team.getAddress();
        var city = team.getCity();
        var zip = team.getZip();
        var tel = team.getTel();
        var website = team.getWebsite();

        if (name != null && !name.equals(teamInDb.getName()))
            teamInDb.setName(name);
        if (address != null && !address.equals(teamInDb.getAddress()))
            teamInDb.setAddress(address);
        if (city != null && !city.equals(teamInDb.getCity()))
            teamInDb.setCity(city);
        if (zip != null && !zip.equals(teamInDb.getZip()))
            teamInDb.setZip(zip);
        if (tel != null && !tel.equals(teamInDb.getTel()))
            teamInDb.setTel(tel);
        if (website != null && !website.equals(teamInDb.getWebsite()))
            teamInDb.setWebsite(website);

        return repository.save(teamInDb);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
}
