package com.kea.kommunevalg.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "politicians")
public class Politician {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "politician_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "party_id"/*, insertable = false, updatable = false*/)
    Party party;

    public Politician(String name, Party party) {
        this.name = name;
        this.party = party;
    }

    public Politician() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
