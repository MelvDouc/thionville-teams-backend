package com.chess.thionvilleteams.mapper;

import com.chess.thionvilleteams.dto.BoardInfoDTO;
import com.chess.thionvilleteams.model.BoardInfo;
import org.springframework.stereotype.Component;

@Component
public class BoardInfoMapper {
    private static final String WHITE_COLOR = "B";
    private static final String BLACK_COLOR = "N";

    public BoardInfoDTO convert(BoardInfo boardInfo) {
        var boardInfoDTO = new BoardInfoDTO();
        var player = boardInfo.getPlayer();
        var match = boardInfo.getMatch();
        var board = boardInfo.getBoard();

        boardInfoDTO.setFfeId(player.getFfeId());
        boardInfoDTO.setLastName(player.getLastName());
        boardInfoDTO.setFirstName(player.getFirstName());
        boardInfoDTO.setBoard(board);
        if ((board % 2 == 1) == (match.getWhiteTeam().getId() == player.getTeamId()))
            boardInfoDTO.setColor(BoardInfoMapper.WHITE_COLOR);
        else
            boardInfoDTO.setColor(BoardInfoMapper.BLACK_COLOR);
        boardInfoDTO.setRating(player.getRating());
        boardInfoDTO.setResult(boardInfo.getResult().ordinal());

        return boardInfoDTO;
    }
}
