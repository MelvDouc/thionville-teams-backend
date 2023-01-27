package com.chess.thionvilleteams.controller;

import com.chess.thionvilleteams.dto.MatchDTO;
import com.chess.thionvilleteams.mapper.MatchMapper;
import com.chess.thionvilleteams.service.MatchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/matches")
@SuppressWarnings("unused")
public class MatchController {
    private final MatchService service;
    private final MatchMapper matchMapper;

    public MatchController(MatchService matchService, MatchMapper matchMapper) {
        this.service = matchService;
        this.matchMapper = matchMapper;
    }

    @GetMapping
    public ResponseEntity<MatchDTO> getOne(@RequestParam("id") long id) {
        return new ResponseEntity<>(matchMapper.convert(service.getById(id)), HttpStatus.OK);
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<MatchDTO>> getAll() {
        return new ResponseEntity<>(service.getAll().stream().map(matchMapper::convert).toList(), HttpStatus.OK);
    }
}
