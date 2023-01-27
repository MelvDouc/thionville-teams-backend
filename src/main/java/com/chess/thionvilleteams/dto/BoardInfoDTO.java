package com.chess.thionvilleteams.dto;

public class BoardInfoDTO {
    private String ffeId;
    private String lastName;
    private String firstName;
    private int board;
    private String color;
    private int rating;
    private int result;

    public String getFfeId() {
        return ffeId;
    }

    public void setFfeId(String ffeId) {
        this.ffeId = ffeId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getBoard() {
        return board;
    }

    public void setBoard(int board) {
        this.board = board;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
