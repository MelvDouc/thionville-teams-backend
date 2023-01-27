package com.chess.thionvilleteams.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "player")
public class Player {
    @Id
    private long id;
    @Column(name = "ffeId", length = 6, nullable = false)
    private String ffeId;
    @Column(name = "lastName", length = 50)
    private String lastName;
    @Column(name = "firstName", length = 50)
    private String firstName;
    @Column(name = "email", length = 100)
    private String email;
    @Column(name = "tel", length = 20)
    private String tel;
    @Column(name = "rating")
    private int rating;
    @Column(name = "teamId")
    private int teamId;
    @Column(name = "updatedAt")
    private String updatedAt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
