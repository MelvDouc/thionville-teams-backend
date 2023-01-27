package com.chess.thionvilleteams.service;

import com.chess.thionvilleteams.exception.ResourceNotFoundException;
import com.chess.thionvilleteams.model.BoardInfo;
import com.chess.thionvilleteams.repository.BoardInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardInfoService implements IService<BoardInfo> {
    private final BoardInfoRepository repository;

    public BoardInfoService(BoardInfoRepository repository) {
        this.repository = repository;
    }

    @Override
    public BoardInfo getById(long id) throws ResourceNotFoundException {
        Optional<BoardInfo> boardInfo = repository.findById(id);

        if (boardInfo.isPresent())
            return boardInfo.get();

        throw new ResourceNotFoundException("BoardInfo", "id", id);
    }

    @Override
    public List<BoardInfo> getAll() {
        return repository.findAll();
    }

    public List<BoardInfo> getAllBySeasonAndRound(int season, int round) {
        return repository.findBySeasonAndRound(season, round);
    }

    @Override
    public BoardInfo create(BoardInfo boardInfo) {
        return repository.save(boardInfo);
    }

    @Override
    public BoardInfo update(BoardInfo boardInfo, long id) {
        var boardInfoInDb = getById(id);
        var result = boardInfo.getResult();

        if (boardInfo.getPlayer().getId() != boardInfoInDb.getPlayer().getId())
            boardInfoInDb.setPlayer(boardInfo.getPlayer());
        if (boardInfo.getMatch().getId() != boardInfoInDb.getMatch().getId())
            boardInfoInDb.setMatch(boardInfo.getMatch());
        if (boardInfo.getBoard() != boardInfoInDb.getBoard())
            boardInfoInDb.setBoard(boardInfo.getBoard());
        if (result != null && !result.equals(boardInfoInDb.getResult()))
            boardInfoInDb.setResult(result);

        return repository.save(boardInfoInDb);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
}
