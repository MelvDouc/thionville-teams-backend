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
    private final MatchMapper mapper;

    public MatchController(MatchService service, MatchMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<MatchDTO> getOne(@RequestParam("id") long id) {
        return new ResponseEntity<>(mapper.convert(service.getById(id)), HttpStatus.OK);
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<MatchDTO>> getAll() {
        return new ResponseEntity<>(service.getAll().stream().map(mapper::convert).toList(), HttpStatus.OK);
    }
}
