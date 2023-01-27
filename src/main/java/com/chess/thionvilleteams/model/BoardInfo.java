package com.chess.thionvilleteams.model;

import jakarta.persistence.*;

@Entity
@Table(name = "boardInfo")
public class BoardInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "playerId", nullable = false)
    private Player player;
    @ManyToOne
    @JoinColumn(name = "matchId", nullable = false)
    private Match match;
    @Column(name = "board")
    private int board;
    @Column(name = "result")
    private Float result;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public int getBoard() {
        return board;
    }

    public void setBoard(int board) {
        this.board = board;
    }

    public Float getResult() {
        return result;
    }

    public void setResult(Float result) {
        if (result == null)
            this.result = -3.14f;
        this.result = result;
    }
}
