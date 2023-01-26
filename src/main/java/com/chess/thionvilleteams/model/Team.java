package com.chess.thionvilleteams.model;

import jakarta.persistence.*;

@Entity
@Table(name = "team")
public class Team {
    @Id
    private long id;
    @Column(name = "name", length = 50)
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "city", length = 20)
    private String city;
    @Column(name = "zip", length = 10)
    private String zip;
    @Column(name = "email", length = 100)
    private String email;
    @Column(name = "tel", length = 20)
    private String tel;
    @Column(name = "website", length = 50)
    private String website;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
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

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
