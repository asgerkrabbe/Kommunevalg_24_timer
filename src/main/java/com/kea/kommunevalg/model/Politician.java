package com.kea.kommunevalg.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "politicians")
public class Politician {

    @Id
    @Column(name = "name", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String name;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    Party party;

    public Politician(String name, Party party) {
        this.name = name;
        this.party = party;
    }

    public Politician() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    @Override
    public String toString() {
        return "navn: " + name + " parti: " + party;
    }
}
