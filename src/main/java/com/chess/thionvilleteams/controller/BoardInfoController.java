package com.chess.thionvilleteams.controller;

import com.chess.thionvilleteams.dto.BoardInfoDTO;
import com.chess.thionvilleteams.mapper.BoardInfoMapper;
import com.chess.thionvilleteams.service.BoardInfoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/board-info")
@SuppressWarnings("unused")
public class BoardInfoController {
    private final BoardInfoService service;
    private final BoardInfoMapper mapper;

    public BoardInfoController(BoardInfoService service, BoardInfoMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<BoardInfoDTO>> getAllByMatchId(@RequestParam("match_id") long matchId) {
        return new ResponseEntity<>(
                service.getAllByMatchId(matchId).stream().map(mapper::convert).toList(),
                HttpStatus.OK
        );
    }
}
